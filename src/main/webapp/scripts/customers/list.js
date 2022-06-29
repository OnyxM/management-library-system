const customersTableElt = document.getElementById("customersTableList");

let customers = [];
let emprunts = [];

function syncCustomers(docs, exem)
{
	customers = docs;
	emprunts = exem;
	customers.forEach((elt, index, array) =>{
		array[index] = {
			...elt,
			emprunts: emprunts.filter(em => em.client_id === elt.id)
		}
	});
	
	console.log(customers);
	setCustomersTableContent();
}

function deleteACustomer(id)
{
	swal({
          title: "Demande de confirmation",
          text: "Confirmez-vous la suppression de ce client ?",
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
					      text: "Le client a été supprimé avec succès !",
					      type: "success",
					      confirmButtonText: 'Ok'
					    }, function(){window.location.reload()});
					}
					else if(this.status >= 400)
					{
						swal({
					      title: "Erreur",
					      text: "Une erreur s'est produite lors de la suppression du client !",
					      type: "error",
					      confirmButtonText: 'Ok'
					    });
					}
				}
		    }
		
		    xmlhttp.open("DELETE", "api/customers/"+id, true);
			xmlhttp.setRequestHeader("Content-Type", "application/json")
		    xmlhttp.send();
        });
        
	
	//customers = customers.filter(elt => elt.id !== id);
	//setCustomersTableContent();
}


function setCustomersTableContent()
{
	let head = "<thead>"+
                    "<tr>"+
                        "<th>#</th>"+
                        "<th>Noms</th>"+
                        "<th>Matricule</th>"+
                        "<th>CNI</th>"+
                        "<th>Téléphone</th>"+
                        "<th>Adresse</th>"+
                        "<th>Date d'adhésion'</th>"+
                        "<th title='nombre d emprunts'>Nbre d'emp.</th>"+
                        "<th>Actions</th>"+
                    "</tr>"+
                "</thead>";
                
    let body = "<tbody>";
    
    customers.forEach((elt) =>{
		body += "<tr>"+
                    "<td>"+elt.id+"</td>"+
                    "<td>"+elt.noms+"</td>"+
                    "<td>"+(elt.matricule ? elt.matricule : '-')+"</td>"+
                    "<td>"+(elt.cni ? elt.cni : '-')+"</td>"+
                    "<td>"+elt.telephone+"</td>"+
                    "<td>"+elt.adresse+"</td>"+
                    "<td>"+getDisplayDate(new Date(elt.date_adhesion))+"</td>"+
                    "<td>"+elt.emprunts.length+"</td>"+
                    "<td>"+
                        "<i class='fas fa-eye text-primary mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-edit text-success mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-times text-danger cursor-pointer action-icon' onclick='deleteACustomer("+elt.id+")'></i>"+
                    "</td>"+
                "</tr>";
	});
	body += "</tbody>";
	customersTableElt.innerHTML = head +""+ body;
}