@BatchPage
Feature: Admin Validating Batch Page
#
  #
  #Background: Admin Logged on the LMS portal
  #
  @BatchPage-01
  Scenario: Validate landing in Batch page
  Given Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  Then Admin should see the "Manage Batch" in the URL
  
  @BatchPage-02
  Scenario: Validate header in the Batch Page
  Given Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  Then Admin should see the "Manage Batch" in the header
  
  #@BatchPage-03
  #Scenario: Validate pagination in the Batch Page
  #Given Admin is on dashboard page after Login
  #When Admin clicks "Batch" from navigation bar
  #Then Admin should see the pagination controls under the data table
  #
  #@BatchPage-04
  #Scenario: Validate data table headers in the Batch Page
  #Given Admin is on dashboard page after Login
  #When Admin clicks "Batch" from navigation bar
  #Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete
  #
  #@BatchPage-05
  #Scenario: Validate Delete button in Batch Page
  #Given Admin is on dashboard page after Login
  #When Admin clicks "Batch" from navigation bar
  #Then Admin should be able to see the "Delete" icon button that is disabled
  #
  #@BatchPage-06
  #Scenario: Validate "+ A New batch" in Batch Page
  #Given Admin is on dashboard page after Login
  #When Admin clicks "Batch" from navigation bar
  #Then Admin should be able to see the "+ A New batch" button
  #
  #@BatchPage-07
  #Scenario: Validate data rows of checkbox
  #Given  Admin is on dashboard page after Login
  #When Admin clicks "Batch" from navigation bar
  #Then Each row in the data table should have a checkbox
  #
  #@BatchPage-08
  #Scenario: Validate data rows of edit icon
  #Given Admin is on dashboard page after Login
  #When Admin clicks "Batch" from navigation bar
  #Then Each row in the data table should have a edit icon that is enabled
  #
  #@BatchPage-09
  #Scenario: Validate data rows of delete icon
  #Given Admin is on dashboard page after Login
  #When Admin clicks "Batch" from navigation bar
  #Then Each row in the data table should have a delete icon that is enabled
  #
   #@BatchPage-10
  #Scenario: Validate pop up for adding batch
   #Given Admin is on batch page after Login
   #When Admin clicks "+ A New Batch" button
   #Then A new pop up with Batch details appears