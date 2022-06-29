const copiesListElt = document.getElementById("copy");
const customersListElt = document.getElementById("customer");
const documentCoverElt = document.getElementById("document-cover");
const addLoanForm = document.addLoan;

const submitButtonElt = document.getElementById("submitButton");
const loaderElt = document.getElementById("loader");

let customers = [];
let documents = [];
let copies = [];
let loans = [];
let occupatedCopies = [];
let occupatedCustomers = [];



hideLoader();

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
	
	occupatedCopies = loans.map(elt =>{if(elt.etat === 0) return elt.exemplaire_id;});
	occupatedCustomers = loans.map(elt =>{if(elt.etat === 0) return elt.client_id;});
	
	setCustomersListContent();
}

function setCustomersListContent()
{
	let temp = customers.filter(elt => !occupatedCustomers.includes(elt.id));
	
	let result = "<option value='' disabled hidden selected>Client désirant emprunter le document</option>";
	temp.forEach((elt) =>{
		result += "<option value='"+elt.id+"'>"+elt.noms+"</option>";
	});
	
	customersListElt.innerHTML = result;
}

function setCopiesListContent(docId)
{
	let temp = documents.find(elt => elt.id === docId);
	temp = !temp ? [] : temp.copies.filter(elt => !occupatedCopies.includes(elt.id));
	
	let result = "<option value='' disabled hidden selected>Exemplaire à préter</option>";
	temp.forEach((elt) =>{
		result += "<option value='"+elt.id+"'>"+elt.code+"</option>";
	});
	
	copiesListElt.innerHTML = result;
}

function onDocumentChange(value)
{
	let document = documents.find(elt => elt.id === parseInt(value));
	documentCoverElt.src = (document?.image && document.image !== "") ? document.image : "public/images/book.jfif";
	setCopiesListContent(parseInt(value));
}

function onCustomerChange(value)
{
	let customer = customers.find(elt => elt.id === parseInt(value));
	addLoanForm.prochNames.value = customer.noms_proche;
	addLoanForm.prochCni.value = customer.cni_proche;
	addLoanForm.prochPhone.value = customer.telephone_proche;
}

function onSubmit()
{
	console.log(addLoanForm.date.value);
  let formIsValid = true;
  for(let i = 0; i < addLoanForm.elements.length; i++)
  {
    const element = addLoanForm.elements[i];
    if(!element.checkValidity())
    {
      formIsValid = false;
      break;
    }
  }

   let temp = new Date();
   let temp2 = new Date(addLoanForm.date.value);
   let temp3 = addLoanForm.date.checkValidity() ? temp2 > temp : false;
  if(!formIsValid || !temp3)
  {
    addLoanForm.classList.add("was-validated");
    
    swal({
      title: "Erreur",
      text: "Formulaire invalide !" + (!temp3 ? "\nLa date de restitution doit est supérieure à la date actuelle !": ""),
      type: "error",
      confirmButtonText: 'Ok'
    });
  }
  else
  {
	showLoader();
	
	let data = {
		exemplaire_id: parseInt(addLoanForm.copy.value),
		client_id: parseInt(addLoanForm.customer.value),
		date_prevue_restitution: new Date(addLoanForm.date.value).getTime(),
		date_emprunt: new Date().getTime(),
		date_restitution: 0,
		etat: 0,
		noms_proche: addLoanForm.prochNames.value,
		cni_proche: addLoanForm.prochCni.value,
		telephone_proche: addLoanForm.prochPhone.value,
	}
	
	const xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function(){
		if(this.readyState == 4)
		{
			hideLoader();
		
			const result = this.responseText;
			if(this.status == 201)
			{
				swal({
			      title: "Succès",
			      text: "L'emprunt' a été créé avec succès !",
			      type: "success",
			      confirmButtonText: 'Ok'
			    }, function(){
				window.location.href="loans/list"
			});
			}
			else if(this.status >= 400)
			{
				swal({
			      title: "Erreur",
			      text: "Une erreur s'est produite lors de la création de l'emprunt' !",
			      type: "error",
			      confirmButtonText: 'Ok'
			    });
			}
		}
		
	}
	
    xmlhttp.open("POST", "api/loans", true);
	xmlhttp.setRequestHeader("Content-Type", "application/json")
    xmlhttp.send(JSON.stringify(data));
  }
}

function showLoader()
{
	loaderElt.style.display = "block";
	submitButtonElt.style.display = "none";	
}

function hideLoader()
{
	loaderElt.style.display = "none";
	submitButtonElt.style.display = "block";
}

