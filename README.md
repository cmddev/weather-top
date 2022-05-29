# weather-top

README: 
WeatherTop Web is a web application that allows users of WeatherTop hand held weather monitoring devices to enter and track their weather readings for their given location or station. 
Build using Java, HTML and utilizing the PLAY Framework, the WeatherTop web application is WeatherTop’s first foray into the world of technology. And it’s only the beginning! 

The following functionality is available to WeatherTop customers: 

Users can sign up to the application (create accounts).
Users can log in to their existing accounts. 
Users can add stations to their accounts. 
Users can delete stations from their accounts. 
Users can add readings to stations. 
Users can delete readings from their stations. 

Known Bugs: 
1.	On the Reading view page for a station,, if a user deletes a reading, the latest weather summary resets to 0 values, even if another reading is still available for the station. 
Expected result: upon deleting a reading, the dashboard should refresh and display the existing readings. 
Workaround: refresh the page manually. 
2.	On the Reading view page for a station, the weather condition icon is not updating to be reflective of the latest weather summary. Current work around is to drop a static icon. 
Expected result: The weather icon should update to match the weather condition, ie. If rainy, rain cloud icon, if sunny, sun icon. 
Workaround: none. 

Future Enhancements: 

1.	User updates to profiles. 
2.	Station dashboard page – present summary of latest weather readings on dashboard page for given station. 
3.	Add trends to latest weather readings. 
