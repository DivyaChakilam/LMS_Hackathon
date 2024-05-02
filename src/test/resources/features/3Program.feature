@Program
Feature: Program

#Background:
@Program_S1
Scenario: Login to app
Given Admin is in Home Page
When Admin enter valid credentials  and clicks login button 
Then Admin should see manage program as header 

@Program_S2
Scenario: Validate landing in Program page
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see URL with Manage Program

@Program_S3
Scenario: Validate the heading
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see a heading with text Manage Program on the page

@Program_S4
Scenario: Validate the text and pagination icon below the data table
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table 

@Program_S5
Scenario: Validate the footer
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see the program footer as In total there are z programs

@Program_S6
Scenario: Validating the default state of Delete button
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see a Delete button on the top left hand side as Disabled

@Program_S7
Scenario: Validate Add New Program
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see a "A New Program" button on the program page above the data table

@Program_S8 
Scenario: Validate that number of records (rows of data in the table) displayed
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see the number of records (rows of data in the table) displayed on the page are 5

@Program_S9
Scenario: Verify data table on the Program page
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see data table on the Manage Program Page with following column headers
|Program Name| 
|Program Description|
|Program Status|
|Edit_Delete|

@Program_S10
Scenario: Verify Sort arrow icon on the data table
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 

@Program_S11
Scenario: Verify Check box on the data table
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see check box on the left side in all rows of the data table 

@Program_S12
Scenario: Verify Edit and Delete buttons
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see the following buttons on each row of the data table
|edit button|
|delete button|

@Program_S13
Scenario: Verify Search bar on the Program page
Given Admin is on dashboard page after Login	
When Admin clicks Program on the navigation bar	
Then Admin should see Search bar with text as "Search..."

@Program_S14
Scenario: Validate Program Details Popup window having SAVE and CANCEL button and Close(X) Icon on the top right corner of the window
Given Admin is on Manage Program Page
When Admin clicks A New Program button	
Then Admin should see a popup open for Program details with empty form along with following buttons
|SAVE|
|CANCEL|
|CloseXIcon|

@Program_S15
Scenario: Validate input fields and their text boxes in Program details form 
Given Admin is on Manage Program Page	
When Admin clicks A New Program button	
Then Admin should see below two input fields and their respective text boxes in the program details window
|ProgramNameInputBox|
|ProgramDescriptionInputBox|

@Program_S16
Scenario: Validate radio button for Program Status 
Given Admin is on Manage Program Page	
When Admin clicks A New Program button	
Then Admin should see two radio button for Program Status
|ActiveStatusRadio|
|InactiveStatusRadio|

@Program_S17
Scenario: Empty form submission
Given Admin is on Program Details Popup window	
When Admin clicks Save button without entering any data	
Then Admin gets a Error message alert 

@Program_S18
Scenario: Enter only Program Name
Given Admin is on Program Details Popup window	
When Admin enters only Program Name in text box and clicks Save button	
Then Admin gets a message alert Description is required

@Program_S19
Scenario: Enter only Program Description
Given Admin is on Program Details Popup window	
When Admin enters only Program description in text box and clicks Save button	
Then Admin gets a message alert Program name is required

@Program_S20
Scenario: Select Status only
Given Admin is on Program Details Popup window	
When Admin selects only Status and clicks Save button	
Then Admin gets a message alert Name and Description required

@Program_S21
Scenario: Validate invalid values on the text column
Given Admin is on Program Details Popup window	
When Admin enters only numbers or special char in name and desc column	
Then Admin gets a Error message alert for invalid values

@Program_S22
Scenario: Validate Cancel/Close(X) icon on Program Details form
Given Admin is on Program Details Popup window	
When Admin clicks CloseX Icon on Program Details form	
Then Program Details popup window should be closed without saving

@Program_S23
Scenario: Validate Save button on Program Details form
Given Admin is on Program Details Popup window	
When Enter all the required fields with valid values and click Save button	
Then Admin gets a message Successful Program Created alert and able to see the new program added in the data table

@Program_S24 
Scenario: Validate Cancel button on Program Details form
Given Admin is on Program Details Popup window	
When Admin clicks Cancel button 	
Then Admin can see the Program details popup disappears without creating any program

@Program_S25 @NavigationBarManageProgram
Scenario: Batch link on navigation bar
Given Admin is on Manage Program page to click on module link
When Admin clicks on Batch link on Manage Program page	
Then Admin is re-directed to Batch page

@Program_S26 @NavigationBarManageProgram
Scenario: User link on navigation bar
Given Admin is on Manage Program page to click on module link
When Admin clicks on User link on Manage Program page	
Then Admin is re-directed to User page

@Program_S27 @DeleteProgram
Scenario: Delete Feature
Given Admin is on Manage Program page to click on module link
When Admin clicks Delete button on the data table for any row	
Then Admin should see a alert open with heading Confirm along with YES and NO button for deletion

@Program_S28 @DeleteProgram
Scenario: Validate details for Confirm Deletion form
Given Admin is on Manage Program Page 	
When Admin clicks Delete button on the data table for any row	
Then Admin should see a message Are you sure you want to delete Program name

@Program_S29 @DeleteProgram
Scenario: Click Yes on deletion window
Given Admin is on Confirm Deletion alert	
When Admin clicks YES button on the alert	
Then Admin gets a message Successful Program Deleted alert and able to see that program deleted in the data table

@Program_S30 @DeleteProgram
Scenario: Click No on deletion window
Given Admin is on Confirm Deletion alert	
When Admin clicks NO button on the alert	
Then Admin can see the deletion alert disappears without deleting

@Program_S31 @DeleteProgram
Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
Given Admin is on Confirm Deletion alert	
When Admin clicks CloseX Icon on Deletion alert	
Then Admin can see the deletion alert disappears without any changes

@Program_S32 @DeleteProgram
Scenario: Validate Common Delete button enabled after clicking on any checkbox
Given Admin is in Manage Program page	
When Admin clicks any checkbox in the data table	
Then Admin should see common delete option enabled under header Manage Program

@Program_S33 @DeleteProgram
Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert	
When Admin clicks YES button on the alert	
Then Admin should land on Manage Program page and can see the selected program is deleted from the data table

@Program_S34 @DeleteProgram
Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert	
When Admin clicks NO button on the alert	
Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table

@Program_S35 @DeleteProgram
Scenario: Validate multiple program deletion by selecting multiple check boxes
Given Admin is on Confirm Deletion alert	
When Admin clicks YES button on the alert	
Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table

@Program_S36 @DeleteProgram
Scenario: Validate multiple program deletion by selecting multiple check boxes
Given Admin is on Confirm Deletion alert	
When Admin clicks NO button on the alert 	
Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table

@Program_S37 @EditProgram
Scenario: Validate Edit Feature
Given Admin is on Manage Program Page 	
When Admin clicks Edit button on the data table for any row	
Then Admin should see a popup open for Program details to edit

@Program_S38 @EditProgram
Scenario: Edit Program Name
Given Admin is on Program Details Popup window to Edit	
When Admin edits the Name column and clicks save button	
Then Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program

@Program_S39 @EditProgram
Scenario: Edit Program description
Given Admin is on Program Details Popup window to Edit	
When Admin edits the Description column and clicks save button	
Then Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program

@Program_S40 @EditProgram
Scenario: Change Program Status
Given Admin is on Program Details Popup window to Edit	
When Admin changes the Status and clicks save button	
Then Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program

@Program_S41 @EditProgram
Scenario: Validate invalid values on the text column
Given Admin is on Program Details Popup window to Edit	
When Admin edits only numbers or special char in name and desc column	
Then Admin gets Error message alert for entering invalid values in text column

@Program_S42 @EditProgram
Scenario: Validate Cancel button on Edit popup
Given Admin is on Program Details Popup window to Edit	
When Admin clicks Cancel button on edit popup	
Then Admin can see the Program details popup disappears and can see nothing changed for particular program

@Program_S43 @EditProgram
Scenario: Validate Save button on Edit popup
Given Admin is on Program Details Popup window to Edit	
When Admin clicks Save button on edit popup	
Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program

@Program_S44  @SortingProgramRecords
Scenario: Validates Sorting program names in ascending on the Program Data table 
Given Admin is on Manage Program page to sort Program Data table
When Admin clicks the sort icon of program name column 
Then The data get sorted on the table based on the program name column values in ascending order

@Program_S45  @SortingProgramRecords
Scenario: Validates Sorting program names in descending on the Program Data table
Given The data is in the ascending order on the table based on Program Name column  
When Admin clicks the sort icon of program name column 
Then The data get sorted on the table based on the program name column values in descending order

@Program_S46  @SortingProgramRecords
Scenario: Validates Sorting program description in ascending on the Program Data table
Given Admin is on Manage Program page to sort Program Data table 
When Admin clicks the sort icon of program Desc column 
Then The data get sorted on the table based on the program description column values in ascending order

@Program_S47  @SortingProgramRecords
Scenario: Validates Sorting program description in descending on the Program Data table
Given The data is in the ascending order on the table based on Program Description column 
When Admin clicks the sort icon of program Desc column 
Then The data get sorted on the table based on the program description column values in descending order

@Program_S48  @SortingProgramRecords
Scenario: Validates Sorting program status in ascending on the Program Data table
Given Admin is on Manage Program page to sort Program Data table
When Admin clicks the sort icon of program Status column 
Then The data get sorted on the table based on the program status column values in ascending order

@Program_S49  @SortingProgramRecords
Scenario: Validates Sorting program status in descending on the Program Data table
Given The data is in the ascending order on the table based on Program Status column  
When Admin clicks the sort icon of program Status column 
Then The data get sorted on the table based on the program status column values in descending order


#@last @NavigationBarManageProgram
#Scenario: Logout link on navigation bar
#Given Admin is on Manage Program page
#When Admin clicks on Logout link on Manage Program page	
#Then Admin is re-directed to Login page