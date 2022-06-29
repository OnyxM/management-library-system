const copiesTableElt = document.getElementById("copiesTableList");

let customers = [];
let copies = [];
let loans = [];

let occupatedCopies = [];


function syncData(doc, cop, lo)
{
	documents = doc;
	copies = cop;
	loans = lo;
	
	occupatedCopies = loans.map(elt => {if(elt.etat === 0) return elt.exemplaire_id;});
	
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
			loans: loans.filter(l => l.exemplaire_id === elt.id),
			isOnLoan: occupatedCopies.includes(elt.id)
		}
	});
	
	loans.forEach((elt, index, array) =>{
		array[index] = {
			...elt,
			copy: copies.find(c => c.id === elt.exemplaire_id)
		}
	});
	
	setCopiesListContent();
}


function deleteACopy(id)
{
	swal({
          title: "Demande de confirmation",
          text: "Confirmez-vous la suppression de cet exemplaire ?",
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
					      text: "L'exemplaire a été supprimé avec succès !",
					      type: "success",
					      confirmButtonText: 'Ok'
					    }, function(){window.location.reload()});
					}
					else if(this.status >= 400)
					{
						swal({
					      title: "Erreur",
					      text: "Une erreur s'est produite lors de la suppression de l'exemplaire !",
					      type: "error",
					      confirmButtonText: 'Ok'
					    });
					}
				}
		    }
		
		    xmlhttp.open("DELETE", "api/copies/"+id, true);
			xmlhttp.setRequestHeader("Content-Type", "application/json")
		    xmlhttp.send();
        });
        
	
	//copies = copies.filter(elt => elt.id !== id);
	//setCopiesTableContent();
}

function setCopiesListContent()
{
	let head = "<thead>"+
                    "<tr>"+
                        "<th>#</th>"+
                        "<th>Code</th>"+
                        "<th>Document</th>"+
                        "<th>Date d'ajout'</th>"+
                        "<th>Statut</th>"+
                        "<th>Actions</th>"+
                    "</tr>"+
                "</thead>";
                
    let body = "<tbody>";
    
    copies.forEach((elt) =>{
		body += "<tr>"+
                    "<td>"+elt.id+"</td>"+
                    "<td>"+elt.code+"</td>"+
                    "<td>"+elt.document.titre+"</td>"+
                    "<td>"+getDisplayDate(new Date(elt.date_ajout))+"</td>"+
                    (elt.isOnLoan ? "<td class='text-danger'>En prêt</td>" : "<td class='text-success'>Libre</td>")+
                    "<td>"+
                        "<i class='fas fa-eye text-primary mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-edit text-success mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-times text-danger cursor-pointer action-icon' onclick='deleteACopy("+elt.id+")'></i>"+
                    "</td>"+
                "</tr>";
	});
	body += "</tbody>";
	copiesTableElt.innerHTML = head +""+ body;
}