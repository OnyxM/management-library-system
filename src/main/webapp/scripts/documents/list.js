const documentsTableElt = document.getElementById("documentsTableList");

let documents = [];
let exemplaires = [];

function syncDocuments(docs, exem)
{
	documents = docs;
	exemplaires = exem;
	documents.forEach((elt, index, array) =>{
		array[index] = {
			...elt,
			exemplaires: exemplaires.filter(ex => ex.document_id === elt.id)
		}
	});
	
	console.log(documents);
	setDocumentsTableContent();
}

function deleteADocument(id)
{
	swal({
          title: "Demande de confirmation",
          text: "Confirmez-vous la suppression de ce document ?",
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
					      text: "Le document a été supprimé avec succès !",
					      type: "success",
					      confirmButtonText: 'Ok'
					    }, function(){window.location.reload()});
					}
					else if(this.status >= 400)
					{
						swal({
					      title: "Erreur",
					      text: "Une erreur s'est produite lors de la suppression du document !",
					      type: "error",
					      confirmButtonText: 'Ok'
					    });
					}
				}
		    }
		
		    xmlhttp.open("DELETE", "api/documents/"+id, true);
			xmlhttp.setRequestHeader("Content-Type", "application/json")
		    xmlhttp.send();
        });
        
	
	//documents = documents.filter(elt => elt.id !== id);
	//setDocumentsTableContent();
}


function setDocumentsTableContent()
{
	let head = "<thead>"+
                    "<tr>"+
                        "<th>#</th>"+
                        "<th>Titre</th>"+
                        "<th>Sujet</th>"+
                        "<th>Maison d'édition</th>"+
                        "<th>Auteurs</th>"+
                        "<th>Date de création</th>"+
                        "<th title='nombre d exemplaires'>Nbre d'ex.</th>"+
                        "<th>Actions</th>"+
                    "</tr>"+
                "</thead>";
                
    let body = "<tbody>";
    
    documents.forEach((elt) =>{
		body += "<tr>"+
                    "<td>"+elt.id+"</td>"+
                    "<td>"+elt.titre+"</td>"+
                    "<td>"+elt.sujet+"</td>"+
                    "<td>"+elt.edition+"</td>"+
                    "<td>"+elt.auteurs+"</td>"+
                    "<td>"+getDisplayDate(new Date(elt.date_ajout))+"</td>"+
                    "<td>"+elt.exemplaires.length+"</td>"+
                    "<td>"+
                        "<i class='fas fa-eye text-primary mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-edit text-success mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-times text-danger cursor-pointer action-icon' onclick='deleteADocument("+elt.id+")'></i>"+
                    "</td>"+
                "</tr>";
	});
	body += "</tbody>";
	documentsTableElt.innerHTML = head +""+ body;
}