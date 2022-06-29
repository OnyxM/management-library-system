function getDisplayDate(date, showHours = false)
{
	return getDayName(date.getDay()) + ", " + date.getDate() + " "+ getMonthName(date.getMonth()) + " "+ date.getFullYear() + (showHours ? (" à "+date.getHours() + "h"+date.getMinutes()): "");
}

function getDayName(dayNumber)
{
	let result ="";
	
	if(dayNumber === 0)
	{
		result = "Dimanche";
	}
	else if(dayNumber === 1)
	{
		result = "Lundi";
	}
	else if(dayNumber === 2)
	{
		result = "Mardi";
	}
	else if(dayNumber === 3)
	{
		result = "Mercredi";
	}
	else if(dayNumber === 4)
	{
		result = "Jeudi";
	}
	else if(dayNumber === 5)
	{
		result = "Vendredi";
	}
	else if(dayNumber === 6)
	{
		result = "Samedi";
	}
	
	return result;
}

function getMonthName(monthNumber)
{
	let result ="";
	
	if(monthNumber === 0)
	{
		result = "Janvier";
	}
	else if(monthNumber === 1)
	{
		result = "Février";
	}
	else if(monthNumber === 2)
	{
		result = "Mars";
	}
	else if(monthNumber === 3)
	{
		result = "Avril";
	}
	else if(monthNumber === 4)
	{
		result = "Mai";
	}
	else if(monthNumber === 5)
	{
		result = "Juin";
	}
	else if(monthNumber === 6)
	{
		result = "Juillet";
	}
	else if(monthNumber === 7)
	{
		result = "Août";
	}
	else if(monthNumber === 8)
	{
		result = "Septembre";
	}
	else if(monthNumber === 9)
	{
		result = "Octobre";
	}
	else if(monthNumber === 10)
	{
		result = "Novembre";
	}
	else if(monthNumber === 11)
	{
		result = "Dècembre";
	}
	
	return result;
}