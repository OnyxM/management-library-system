const countValueElt = document.getElementById("count-value");
const addCopyForm = document.addCopy;
const copiesInputsElt = document.getElementById("copiesInputs");
const selectDocumentForm = document.selectDocument;
const selectDocumentInput = document.getElementById("select-document");

const submitButtonElt = document.getElementById("submitButton");
const loaderElt = document.getElementById("loader");

let copies = [];

let count = 1;

addACopy();
hideLoader();

function setCountValueContent()
{
	countValueElt.textContent = count;
}

function increaseCount()
{
	if(count < 10)
	{
		++count;
		addACopy();
		setCountValueContent();
	}
}

function decreaseCount()
{
	if(count > 1)
	{
		--count;
		deleteACopy();
		setCountValueContent();
	}
}

function addACopy()
{
	copies.push({
		code: ""
	});
	setCopiesFormContent();
}

function deleteACopy(index = null)
{
	if(copies.length > 1)
	{
		console.log(index);
		--count;
		setCountValueContent();
		index = index ? index : copies.length - 1;
		console.log(copies);
		copies = copies.filter((elt, i) => i !== index);
		console.log(copies);
		setCopiesFormContent();
	}
}

function setCopyCode(index, value)
{
	copies[index].code = value;
}

function setCopiesFormContent()
{
	let temp = "";
	
	copies.forEach((elt, index) =>{
		let position = index + 1;
		let id = "code"+position;
		temp += "<div class='card col-md-6'>"+
                    "<div class='card-header d-flex justify-content-between align-items-center'>"+                               
                        "<h6 class='card-title'>Exemplaire N° "+position+ (index === 0 ? '' : ("<i onclick='deleteACopy("+index+")' class='fas fa-times cursor-pointer text-danger delte-icon'></i>"))+"</h6>"+                        
                    "</div>"+
                    "<div class='card-body'>"+
                        "<input type='text' class='form-control' onchange='setCopyCode("+index+", this.value)' value='"+elt.code+"' id='"+id+"' name='"+id+"' placeholder='ISBN de l exemplaire' maxlength='30' required>"+
                    "<div class='invalid-feedback' id='"+id+"-error'>Le code de l'exemplaire est requis !</div>"+
                    "</div>"+
                "</div>";
	});
	
	copiesInputsElt.innerHTML = temp;
}

function onSubmit()
{
  let formIsValid = true;
  let hasSelectedDocument = selectDocumentInput.checkValidity() && selectDocumentInput.value !== "";
  
  for(let i = 0; i < addCopyForm.elements.length; i++)
  {
    const element = addCopyForm.elements[i];
    if(!element.checkValidity())
    {
      formIsValid = false;
      break;
    }
  }

  if(!formIsValid || !hasSelectedDocument)
  {
	if(!formIsValid)
    	addCopyForm.classList.add("was-validated");
    	
	if(!hasSelectedDocument)
		selectDocumentForm.classList.add("was-validated");
    
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
	let document_id = parseInt(selectDocumentInput.value);
	
	let data = copies.map(elt => {return {document_id: document_id, code: elt.code, date_ajout: new Date().getTime()}});
	
	const xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function(){
		if(this.readyState == 4)
		{
			hideLoader();
		
			const result = this.responseText;
			if(this.status == 201)
			{
				let message = copies.length > 1 ? "Les exemplaires ont été créé avec succès !" : "L'exemplaire a été créé avec succès !";
				swal({
			      title: "Succès",
			      text: message,
			      type: "success",
			      confirmButtonText: 'Ok'
			    }, function(){
				window.location.href="copies/list"
			});
			}
			else if(this.status >= 400)
			{
				swal({
			      title: "Erreur",
			      text: "Une erreur s'est produite lors de la création " +(copies.length > 1 ? "des exemplaires !" : "de l'exemplaire !"),
			      type: "error",
			      confirmButtonText: 'Ok'
			    });
			}
		}
		
	}
	
    xmlhttp.open("POST", "api/copies", true);
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