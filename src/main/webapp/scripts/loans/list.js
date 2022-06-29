const loansTableElt = document.getElementById("loansTableList");

let customers = [];
let documents = [];
let copies = [];
let loans = [];

let occupatedCopies = [];
let occupatedCustomers = [];


function syncData(cus, doc, cop, lo)
{
	customers = cus;
	documents = doc;
	copies = cop;
	loans = lo;
	
	documents.forEach((elt, index, array) =>{
		array[index] = {
			...elt,
			copies: copies.filter(c => c.document_id === elt.id)
		}
	});
	
	copies.forEach((elt, index, array) =>{
		array[index] = {
			...elt,
			document: documents.find(d => d.id === elt.document_id),
			loans: loans.filter(l => l.exemplaire_id === elt.id)
		}
	});
	
	loans.forEach((elt, index, array) =>{
		array[index] = {
			...elt,
			copy: copies.find(c => c.id === elt.exemplaire_id),
			customer: customers.find(c => c.id === elt.client_id)
		}
	})
	
	occupatedCopies = loans.map(elt =>{if(elt.etat === 0) return elt.exemplaire_id;});
	occupatedCustomers = loans.map(elt =>{if(elt.etat === 0) return elt.client_id;});
	
	setLoansListContent();
}


function deleteALoan(id)
{
	swal({
          title: "Demande de confirmation",
          text: "Confirmez-vous la suppression de cet emprunt ?",
          type: "warning",
          showCancelButton: true,
          closeOnConfirm: false,
          showLoaderOnConfirm: true,
          confirmButtonText: 'Oui',
          cancelButtonText: 'Annuler'
        }, function () {
			const xmlhttp = new XMLHttpRequest();
		    xmlhttp.onreadystatechange = function(){
			    if(this.readyState == 4)
				{
					const result = this.responseText;
					if(this.status == 200)
					{
						swal({
					      title: "Succès",
					      text: "L'emprunt a été supprimé avec succès !",
					      type: "success",
					      confirmButtonText: 'Ok'
					    }, function(){window.location.reload()});
					}
					else if(this.status >= 400)
					{
						swal({
					      title: "Erreur",
					      text: "Une erreur s'est produite lors de la suppression de l'emprunt !",
					      type: "error",
					      confirmButtonText: 'Ok'
					    });
					}
				}
		    }
		
		    xmlhttp.open("DELETE", "api/loans/"+id, true);
			xmlhttp.setRequestHeader("Content-Type", "application/json")
		    xmlhttp.send();
        });
        
	
	//loans = loans.filter(elt => elt.id !== id);
	//setLoansTableContent();
}

function setLoansListContent()
{
	let head = "<thead>"+
                    "<tr>"+
                        "<th>#</th>"+
                        "<th>Client</th>"+
                        "<th>Exemplaire</th>"+
                        "<th>Document</th>"+
                        "<th>Date d'emprunt</th>"+
                        "<th title='Date prévue pour la restitution'>Date prev. rest,</th>"+
                        "<th title='Date de restitution'>Date rest.</th>"+
                        "<th>Statut</th>"+
                        "<th>Actions</th>"+
                    "</tr>"+
                "</thead>";
                
    let body = "<tbody>";
    
    loans.forEach((elt) =>{
		let doc = documents.find(d => d.id === elt.copy.document_id);
		body += "<tr>"+
                    "<td>"+elt.id+"</td>"+
                    "<td>"+elt.customer.noms+"</td>"+
                    "<td>"+elt.copy.code+"</td>"+
                    "<td>"+doc.titre+"</td>"+
                    "<td>"+getDisplayDate(new Date(elt.date_emprunt), true)+"</td>"+
                    "<td>"+getDisplayDate(new Date(elt.date_prevue_restitution), true)+"</td>"+
                    "<td>"+(elt.date_restitution === 0 ? "-" : getDisplayDate(new Date(elt.date_restitution), true))+"</td>"+
                    (elt.etat === 0 ? "<td class='text-danger'>Non restitué</td>" : "<td class='text-success'>Restitué</td>")+
                    "<td>"+
                        "<i class='fas fa-eye text-primary mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-edit text-success mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-times text-danger cursor-pointer action-icon' onclick='deleteALoan("+elt.id+")'></i>"+
                    "</td>"+
                "</tr>";
	});
	body += "</tbody>";
	loansTableElt.innerHTML = head +""+ body;
}