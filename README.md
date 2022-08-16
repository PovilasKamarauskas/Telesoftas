Test automation task.

How to run test

1. Make sure Java 15+ is downloaded and added to the "JAVA_HOME" and "PATH".
2. Make sure Maven is downloaded and added to the "M2_HOME".
3. Clone repository into your desired directory.
4. Open CMD if Java and Maven correctly install execute mvn test and test case will run. 

Q- How would you test specifically the search feature on the tiketa platform? Suggest
mechanism/layer rather than test cases.

A-Tiketa search has a lot of different filters, so I would start with basic API testing to check if all "sliders" works as intended, then same test cases could be checked against UI implementation as well. Internal Search engines can be heavily contrainted f.e checking if word entered is capital letter or not, there is a lot what can go wrong with Search feature.  

Q- How would you set up for testing this feature with automation in mind?

A- I would write down basic functionality I want to see from Internal Search Engine:
    Is it acurate?
    Is it easy to use? 
    Is it heavily contrained?
    Is it fast? 
   
By following simple cases firstly, we can firstly make sure that main, desired functionality is working as user expects and afterwards start tackling edge cases if they are important to the product. 
