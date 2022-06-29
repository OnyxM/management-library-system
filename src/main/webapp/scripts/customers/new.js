const addCustomerForm = document.addCustomer;

const namesErrorElt = document.getElementById("names-error");
const identifiantErrorElt = document.getElementById("identifiant-error");
const phoneErrorElt = document.getElementById("phone-error");
const addressErrorElt = document.getElementById("address-error");

const prochNamesErrorElt = document.getElementById("proch-names-error");
const prochPhoneErrorElt = document.getElementById("proch-phone-error");
const prochCniErrorElt = document.getElementById("proch-cni-error");

const identifiantLabelElt = document.getElementById("identifiant-label");

const namesInput = addCustomerForm.names;
const identifiantInput = addCustomerForm.identifiant;
const phoneInput = addCustomerForm.phone;
const addressInput = addCustomerForm.address;

const prochNamesInput = addCustomerForm.prochNames;
const prochPhoneInput = addCustomerForm.prochPhone;
const prochCniInput = addCustomerForm.prochCni;

const submitButtonElt = document.getElementById("submitButton");
const loaderElt = document.getElementById("loader");

const MATRICULE = "Matricule";
const MATRICULE_PLACEHOLDER = MATRICULE + " de l'étudiant'";
const CNI = "Numéro de CNI";
const CNI_PLACEHOLDER = CNI + " du client";
let CURRENT_IDENTIFIANT = MATRICULE;

hideLoader();
onCustomerTypeChange(1);

function onCustomerTypeChange(value)
{
	CURRENT_IDENTIFIANT = parseInt(value) === 1 ? MATRICULE : CNI;
	
	identifiantLabelElt.innerHTML = CURRENT_IDENTIFIANT + " <span class='text-danger'>*</span>";
	identifiantInput.placeholder = CURRENT_IDENTIFIANT === CNI ? CNI_PLACEHOLDER : MATRICULE_PLACEHOLDER;
	
}

function syncCurrentIdentifiant()
{
	
}
        
function onSubmit()
{
  let formIsValid = true;
  for(let i = 0; i < addCustomerForm.elements.length; i++)
  {
    const element = addCustomer.elements[i];
    if(!element.checkValidity())
    {
      formIsValid = false;
      break;
    }
  }

  if(!formIsValid)
  {
    addCustomerForm.classList.add("was-validated");
    if(!namesInput.checkValidity())
    {
      if(namesInput.value === "")
      {
        namesErrorElt.textContent = "Le Nom est requis !";
      }
      else if(namesInput.value.length > 60)
      {
        namesErrorElt.textContent = "Le nom doit avoir au plus 60 caractères !";
      }
    }

    if(!identifiantInput.checkValidity())
    {
      if(identifiantInput.value === "")
      {
        identifiantErrorElt.textContent = "Le sujet est requis !";
      }
      else if(identifiantInput.value.length > 30)
      {
        identifiantErrorElt.textContent = "Le "+CURRENT_IDENTIFIANT+" doit avoir au plus 30 caractères !";
      }
    }

    if(!phoneInput.checkValidity())
    {
      if(phoneInput.value === "")
      {
        phoneErrorElt.textContent = "Le numéro de téléphone est requis !";
      }
      else if(phoneInput.value.length > 20)
      {
        phoneErrorElt.textContent = "Le numéro de téléphone doit avoir au plus 20 caractères !";
      }
    }

    if(!addressInput.checkValidity())
    {
      if(addressInput.value.length > 255)
      {
        addressErrorElt.textContent = "L'adresse doit avoir au plus 255 caractères !";
      }
    }
    
    if(!prochNamesInput.checkValidity())
    {
      if(prochNamesInput.value.length > 60)
      {
        prochNamesErrorElt.textContent = "Le nom doit avoir au plus 255 caractères !";
      }
    }
    
    if(!prochPhoneInput.checkValidity())
    {
      if(prochPhoneInput.value.length > 20)
      {
        prochPhoneErrorElt.textContent = "Le numéro de téléphone doit avoir au plus 20 caractères !";
      }
    }
    
    if(!prochCniInput.checkValidity())
    {
      if(prochCniInput.value.length > 30)
      {
        prochCniErrorElt.textContent = "Le "+CNI+" doit avoir au plus 20 caractères !";
      }
    }
    
    swal({
      title: "Erreur",
      text: "Formulaire invalide !",
      type: "error",
      confirmButtonText: 'Ok'
    });
  }
  else
  {
	showLoader();
	
	let data = {
		noms: namesInput.value,
		matricule: CURRENT_IDENTIFIANT === CNI ? null : identifiantInput.value,
		cni: CURRENT_IDENTIFIANT === CNI ? identifiantInput.value : null,
		telephone: phoneInput.value,
		adresse: addressInput.value,
		date_adhesion: new Date().getTime(),
		noms_proche: prochNamesInput.value,
		cni_proche: prochCniInput.value,
		telephone_proche: prochPhoneInput.value
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
			      text: "Le client a été créé avec succès !",
			      type: "success",
			      confirmButtonText: 'Ok'
			    }, function(){
				window.location.href="customers/list"
			});
			}
			else if(this.status >= 400)
			{
				swal({
			      title: "Erreur",
			      text: "Une erreur s'est produite lors de la création du client !",
			      type: "error",
			      confirmButtonText: 'Ok'
			    });
			}
		}
		
	}
	
    xmlhttp.open("POST", "api/customers", true);
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
