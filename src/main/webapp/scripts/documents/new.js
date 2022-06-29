const dropArea = document.querySelector(".drag-area"),
        dragText = dropArea.querySelector(".drag-header"),
        button = dropArea.querySelector(".browse-button"),
        input = dropArea.querySelector(".upload-input");

const progressDiv = document.getElementById("progress");
const progressDivCont = document.getElementById("progress-cont");

const importDiv = document.getElementById("import");
const fileNameElt = document.getElementById("file-name");

const addDocumentForm = document.addDocument;

const titleErrorElt = document.getElementById("title-error");
const subjectErrorElt = document.getElementById("subject-error");
const editionErrorElt = document.getElementById("edition-error");
const authorsErrorElt = document.getElementById("authors-error");

const titleInput = addDocumentForm.title;
const subjectInput = addDocumentForm.subject;
const editionInput = addDocumentForm.edition;
const authorsInput = addDocumentForm.authors;

const submitButtonElt = document.getElementById("submitButton");
const loaderElt = document.getElementById("loader");

let image = "";

hideLoader();
        
button.onclick = ()=>{
  input.click(); 
}

input.addEventListener("change", function(){
  if(isValidFileType(this.files[0]))
  {
	file = event.dataTransfer.files[0];
	uploadFileSimulator(file);
  }
  dropArea.classList.add("active");
  showFile(); 
});

dropArea.addEventListener("dragover", (event)=>{
  event.preventDefault();
  dropArea.classList.add("active");
  dragText.textContent = "Relâchez pour charger";
});


dropArea.addEventListener("dragleave", ()=>{
  dropArea.classList.remove("active");
  dragText.textContent = "Glissez et déposez votre image ici";
});


dropArea.addEventListener("drop", (event)=>{
  event.preventDefault();
  if(isValidFileType(event.dataTransfer.files[0]))
  {
	file = event.dataTransfer.files[0];
	uploadFileSimulator(file);
  }
});

function isValidFileType(file)
{
	let validExtensions = ["image/jpeg", "image/png", "image/jpg"]
	let fileType = file?.type; 
	let result = false;
  	if(validExtensions.includes(fileType)){
		result = true;
	}
	else{
  		alert("Uniquement les fichiers images sont permis !");
	    result = false;
	}
	
	dropArea.classList.remove("active");
  	dragText.textContent = "Glissez et déposez votre image ici";
  	
  	return result;
}

function uploadFileSimulator(file) {
	progress = 0;
    setTimeout(() => {
      if (!file) {
        return;
      } else {
		showProgress(0);
        showImportDiv(file.name);
        const progressInterval = setInterval(() => {
          if (progress === 100) {
            clearInterval(progressInterval);
            hideProgress();
            readFile();
          } else {
            progress += 5;
            showProgress(progress);
          }
        }, 200);
      }
    }, 1000);
  }
  
function showProgress(progress)
{
	progressDiv.style.width = (450 * progress/100)+"px";
	progressDivCont.style.display = "block";
}

function hideProgress(){
	progress = 0;
	progressDivCont.style.display = "none";
	hideImportDiv();
}

function hideImportDiv(){
	importDiv.style.display = "none";
}

function showImportDiv(filename){
	importDiv.style.display = "block";
	fileNameElt.textContent = filename;
}

function readFile()
{
  let fileReader = new FileReader();
  fileReader.onloadend = function(){
    dropArea.style.backgroundImage = "url('"+this.result+"')";
    image = this.result;
  }
  fileReader.readAsDataURL(file);
}

function onSubmit()
{
  let formIsValid = true;
  for(let i = 0; i < addDocumentForm.elements.length; i++)
  {
    const element = addDocument.elements[i];
    if(!element.checkValidity())
    {
      formIsValid = false;
      break;
    }
  }

  if(!formIsValid)
  {
    addDocumentForm.classList.add("was-validated");
    if(!titleInput.checkValidity())
    {
      if(titleInput.value === "")
      {
        titleErrorElt.textContent = "Le titre est requis !";
      }
      else if(titleInput.value.length > 255)
      {
        titleErrorElt.textContent = "Le titre doit avoir au plus 30 caractères !";
      }
    }

    if(!subjectInput.checkValidity())
    {
      if(subjectInput.value === "")
      {
        subjectErrorElt.textContent = "Le sujet est requis !";
      }
      else if(subjectInput.value.length > 255)
      {
        subjectErrorElt.textContent = "Le sujet doit avoir au plus 255 caractères !";
      }
    }

    if(!editionInput.checkValidity())
    {
      if(editionInput.value === "")
      {
        editionErrorElt.textContent = "La maison d'édition est requise !";
      }
      else if(editionInput.value.length > 255)
      {
        editionErrorElt.textContent = "La maison d'édition doit avoir au plus 255 caractères !";
      }
    }

    if(!authorsInput.checkValidity())
    {
      if(authorsInput.value === "")
      {
        authorsErrorElt.textContent = "Les auteurs sont requis !";
      }
      else if(authorsInput.value.length > 255)
      {
        authorsErrorElt.textContent = "Ce champ doit avoir au plus 255 caractères !";
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
		titre: titleInput.value,
		sujet: subjectInput.value,
		edition: editionInput.value,
		auteurs: authorsInput.value,
		date_ajout: new Date().getTime(),
		image: image,
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
			      text: "Le document a été créé avec succès !",
			      type: "success",
			      confirmButtonText: 'Ok'
			    }, function(){
				window.location.href="documents/list"
			});
			}
			else if(this.status >= 400)
			{
				swal({
			      title: "Erreur",
			      text: "Une erreur s'est produite lors de la création du document !",
			      type: "error",
			      confirmButtonText: 'Ok'
			    });
			}
		}
		
	}
	
    xmlhttp.open("POST", "api/documents", true);
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
