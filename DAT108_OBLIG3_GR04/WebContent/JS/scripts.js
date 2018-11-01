document.getElementById("inputFornavn").addEventListener("keyup", sjekkfornavn);
document.getElementById("inputEtternavn").addEventListener("keyup", sjekketternavn);
document.getElementById("inputMobil").addEventListener("keyup", sjekkmobil);
document.getElementById("passordEnInput").addEventListener("keyup", sjekkpass);
document.getElementById("passordToInput").addEventListener("keyup", sjekkpasslikhet);


function sjekkfornavn(){
	let fornavn = document.getElementById("inputFornavn").value;
	let feilmelding = document.getElementById("feilFornavn");
	let regex = /^[A-Z\xC6\xC5\xD8][A-Za-z- \xC6\xC5\xD8\xE5\xE6\xF8]{1,19}$/; 
	
	if (!regex.test(fornavn)){
		feilmelding.innerHTML = "Ugyldig fornavn!";
	} else {
		feilmelding.innerHTML = "";
	}
}

function sjekketternavn(){
	let fornavn = document.getElementById("inputEtternavn").value;
	let feilmelding = document.getElementById("feilEtternavn");
	let regex = /^[A-Z\xC6\xC5\xD8][A-Za-z-\xC6\xC5\xD8\xE5\xE6\xF8]{1,19}$/; 
	
	if (!regex.test(fornavn)){
		feilmelding.innerHTML = "Ugyldig etternavn!";
	} else {
		feilmelding.innerHTML = "";
	}
}

function sjekkmobil(){
	let mobil = document.getElementById("inputMobil").value;
	let feilmelding = document.getElementById("feilMobil");
	let regex = /^[0-9]{8,8}$/; 
	
	if (!regex.test(mobil)){
		feilmelding.innerHTML = "Ugyldig telefonnummer!";
	} else {
		feilmelding.innerHTML = "";
	}
}

function sjekkpass() {
    let passord = document.getElementById("passordEnInput").value;
    let styrke = document.getElementById("styrkePass");
    let ugyldig = document.getElementById("feilPassord");
    let svakReg = /^(?=.*[a-z0-9])(?=.{5,})/;
    let medReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{5,})/;
    let sterkReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;

    if (sterkReg.test(passord)){
        ugyldig.innerHTML = "Sterkt passord!";
        ugyldig.style.color = "white";
        ugyldig.style.backgroundColor = "#00aa53";
        ugyldig.style.borderColor = "white";
    }
    else if (medReg.test(passord)){
        ugyldig.innerHTML = "Greit passord";
        ugyldig.style.color = "white";
        ugyldig.style.backgroundColor = "#009eab";
        ugyldig.style.borderColor = "white";
    }
    else if (svakReg.test(passord)){
        ugyldig.innerHTML = "Svakt passord!";
        ugyldig.style.color = "white";
        ugyldig.style.backgroundColor = "#d72d1d";
        ugyldig.style.borderColor = "white";
    }
    else {
        ugyldig.innerHTML = "Ikke gyldig passord!";
        ugyldig.style.backgroundColor = "#7168ec";
        ugyldig.style.color = "#d72d1d";
        ugyldig.style.borderColor = "#7168ec";
    }
}

function sjekkpasslikhet(){
	let passord1 = document.getElementById("passordEnInput").value;
	let passord2 = document.getElementById("passordToInput").value;
	let ikkeMatch = document.getElementById("feilPassordMatch");
	
	if(passord1.localeCompare(passord2) != 0){
		ikkeMatch.innerHTML = "Passordene matcher ikke!"
	} else {
		ikkeMatch.innerHTML = "";
	}
}