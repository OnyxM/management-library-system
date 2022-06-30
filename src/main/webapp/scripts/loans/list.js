const loansTableElt = document.getElementById("loansTableList");

const documentElt = document.getElementById("document");
const copyElt = document.getElementById("copy");
const customerElt = document.getElementById("customer");
const date1Elt = document.getElementById("date1");
const date2Elt = document.getElementById("date2");
const date3Elt = document.getElementById("date3");
const phone1Elt = document.getElementById("phone1");
const phone2Elt = document.getElementById("phone2");
const cniElt = document.getElementById("cni");
const stateElt = document.getElementById("state");
const prochElt = document.getElementById("proch");
const documentCoverElt = document.getElementById("document-cover");

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
	
	console.log(loans);
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

function restituteALoan(id)
{
	let data = loans.find(elt => elt.id === id);
	data = {
		...data,
		etat: 1,
		date_restitution: new Date().getTime()
	}
	const xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function(){
	    if(this.readyState == 4)
		{
			const result = this.responseText;
			if(this.status == 201)
			{
				swal({
			      title: "Succès",
			      text: "L'emprunt a été restitué avec succès !",
			      type: "success",
			      confirmButtonText: 'Ok'
			    }, function(){window.location.reload()});
			}
			else if(this.status >= 400)
			{
				swal({
			      title: "Erreur",
			      text: "Une erreur s'est produite lors de la restitution de l'emprunt !",
			      type: "error",
			      confirmButtonText: 'Ok'
			    });
			}
		}
    }

    xmlhttp.open("PUT", "api/loans/"+id, true);
	xmlhttp.setRequestHeader("Content-Type", "application/json")
    xmlhttp.send(JSON.stringify(data));
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
                        "<th>Restituer</th>"+
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
                    (elt.etat === 0 ? "<td class='text-danger'>Non restitué</td><td><i onclick='restituteALoan("+elt.id+")' class='action-icon text-secondary cursor-pointer fas fa-thumbs-up'></i></td>" : "<td class='text-success'>Restitué</td><td></td>")+
                    "<td>"+
                        "<i onclick='onViewLoanDetails("+elt.id+")' data-toggle='modal' data-target='#exampleModalCenter' class='fas fa-eye text-primary mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-edit text-success mr-2 cursor-pointer action-icon'></i>"+
                        "<i class='fas fa-times text-danger cursor-pointer action-icon' onclick='deleteALoan("+elt.id+")'></i>"+
                    "</td>"+
                "</tr>";
	});
	body += "</tbody>";
	loansTableElt.innerHTML = head +""+ body;
}

function onViewLoanDetails(id)
{
	let loan = loans.find(elt => elt.id === id);
	console.log(loan)
	
	let doc =  documents.find(elt => elt.id === loan.copy.document_id);
	
	documentElt.textContent = doc.titre;
	copyElt.textContent = loan.copy.code;
	customerElt.textContent = loan.customer.noms;
	date1Elt.textContent = getDisplayDate(new Date(loan.date_emprunt), true);
	date2Elt.textContent = getDisplayDate(new Date(loan.date_prevue_restitution), true);
	date3Elt.textContent = loan.date_restitution !== 0 ? getDisplayDate(new Date(loan.date_restitution), true): "-";
	cniElt.textContent = loan.cni_proche;
	phone2Elt.textContent = loan.telephone_proche;
	prochElt.textContent = loan.noms_proche;
	phone1Elt.textContent = loan.customer.telephone;
	stateElt.classList.remove("text-danger");
	stateElt.classList.remove("text-success");
	stateElt.textContent = loan.etat === 0 ? "Non restitué" : "restitué";
	stateElt.classList.add(loan.etat === 0 ? "text-danger" : "text-success");
	documentCoverElt.src = (doc?.image && doc.image !== "") ? doc.image : "public/images/book.jfif";
}