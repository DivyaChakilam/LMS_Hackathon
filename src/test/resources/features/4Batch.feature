@BatchPage
Feature: Admin Validating Batch Page

  
  Background: Admin Logged on the LMS portal
  
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
  
  @BatchPage-03
  Scenario: Validate pagination in the Batch Page
  Given Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  Then Admin should see the pagination controls under the data table
  
  @BatchPage-04
  Scenario: Validate data table headers in the Batch Page
  Given Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete
  
  @BatchPage-05
  Scenario: Validate Delete button in Batch Page
  Given Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  Then Admin should be able to see the "Delete" icon button that is disabled
  
  @BatchPage-06
  Scenario: Validate "+ A New batch" in Batch Page
  Given Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  Then Admin should be able to see the "+ A New batch" button
  
  @BatchPage-07
  Scenario: Validate data rows of checkbox
  Given  Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  Then Each row in the data table should have a checkbox
  
  @BatchPage-08
  Scenario: Validate data rows of edit icon
  Given Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  Then Each row in the data table should have a edit icon that is enabled
  
  @BatchPage-09
  Scenario: Validate data rows of delete icon
  Given Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  Then Each row in the data table should have a delete icon that is enabled
  
   @BatchPage-10
  Scenario: Validate pop up for adding batch
   Given Admin is on batch page after Login
   When Admin clicks "+ A New Batch" button
   Then A new pop up with Batch details appears
    @BatchPage-11
   Scenario Outline: Validate feils in popUp page
   Given Admin is on batch page after Login
  When Admin clicks "+ A New Batch" button
  Then The pop up should include the "<FeildNames>" as respective text boxs,radio button,dropdown
   Examples:
   | FeildNames       |
   | BatchName        |
   | BatchDescription |
   | ProgramName      |
   | Status           |
   | NoOfclasses      |
  @BatchPage-12
  Scenario Outline: Check if description is optional field
    Given A new pop up with Batch details appears after clicking add batch on BatchPage
    When Fill in all the "<BatchName>","< BatchDescription>","<ProgramName>" and "<NoOfclasses>" except description with valid values and click save
    Then The newly added batch should be present in the data table in Manage Batch page

    Examples: 
      | BatchName | BatchDescription | ProgramName | NoOfclasses |
      | SDET137   |                  | LMSprogram  |           3 |

  @BatchPage-13
  Scenario Outline: Check if the program details are added in data table
    Given A new pop up with Batch details appears after clicking add batch on BatchPage
    When Fill in all the "<BatchName>","< BatchDescription>","<ProgramName>" and "<NoOfclasses>" with valid values and click save
    Then The newly added batch should be present in the data table in Manage Batch page when you search

    Examples: 
      | BatchName | BatchDescription | ProgramName | NoOfclasses |
      | OOPS02    | Testing          | LMSprogram  |           3 |

  @BatchPage-14
  Scenario Outline: Check for error messages for invalid fields
    Given A new pop up with Batch details appears after clicking add batch on BatchPage
    When Fill in all the "<BatchName>","< BatchDescription>","<ProgramName>" and "<NoOfclasses>" with batch name invalid value and click save
    Then Error message should appear for batch name

    Examples: 
      | BatchName | BatchDescription | ProgramName | NoOfclasses |
      | @@@       | Testing          | LMSprogram  |           3 |

  @BatchPage-15
  Scenario Outline: Check for error messages for mandatory fields
    Given A new pop up with Batch details appears after clicking add batch on BatchPage
    When Fill in all the "<BatchName>","< BatchDescription>","<ProgramName>" and "<NoOfclasses>" with program name empty value and click save
    Then Error message should appear for program name

    Examples: 
      | BatchName | BatchDescription | ProgramName | NoOfclasses |
      | OOPS01    | Testing          |             |           3 |

  @BatchPage-16
  Scenario: Validate row level delete icon
    Given The delete icon on row level in data table is enabled after landing on batchpage
    When Admin clicks the delete icon
    Then Alert appears with yes and No option

  @BatchPage-17
  Scenario: Validate accept alert
    Given Admin clicks the delete icon for one batch after landing on batchpage
    When Admin click yes option
    Then Batch deleted alert pops and batch is no more available in the data table

  @BatchPage-18
  Scenario: Validate reject alert
    Given Admin clicks the delete icon for another batch after landing on batchpage
    When Admin click No option
    Then Batch is still listed in data table after searching

  @BatchPage-19
  Scenario: Validate the delete icon below the header
    Given None of the checkboxes in data table are selected after landing on batchpage
    Then The delete icon under the "Manage Batch" header should be disabled

  @BatchPage-20
  Scenario: Check for single row delete
    Given One of the checkbox of row is selected after landing on batchpage
    When Click delete icon below "Manage Batch" header
    Then The respective row in the data table is deleted

  @BatchPage-21
  Scenario: Check for multi row delete
    Given Two or more checkboxes of row is selected after landing on batchpage
    When Click delete icon below "Manage Batch" header
    Then The respective row in the data table is deleted for selected rows

   @BatchPage-22
   Scenario: Validate row level edit icon
    Given The edit icon on row level in data table is enabled after landing on batchpage
   When Admin clicks the edit icon
   Then A new pop up with Batch details appears
   
  @BatchPage-23
  Scenario Outline: Check if the fields are updated
    Given Admin clicks the edit icon after landing on batchpage
    When Update the fields "<BatchName>","< BatchDescription>","<ProgramName>" and "<NoOfclasses>"  click save
    Then The updated batch details should appear on the data table

    Examples: 
      | BatchName | BatchDescription | ProgramName | NoOfclasses |
      | OOPS04    | Testing001       | LMSprogram  |           4 |

  @BatchPage-24
  Scenario Outline: Check if the update throws error with invalid values
    Given Admin clicks the edit icon after landing on batchpage
    When Update the fields "<BatchName>","< BatchDescription>","<ProgramName>" and "<NoOfclasses>" with invalid description click save
    Then Error message should appear

    Examples: 
      | BatchName | BatchDescription | ProgramName | NoOfclasses |
      | OOPS04    | @2332            | LMSprogram  |           4 |

  @BatchPage-25
  Scenario Outline: Check if you get error message when mandatory fields are erased
    Given Admin clicks the edit icon after landing on batchpage
    When Update the fields "<BatchName>","< BatchDescription>","<ProgramName>" and "<NoOfclasses>" with no noOfClasses click save
    Then Error message should appear for mandatory fields

    Examples: 
      | BatchName | BatchDescription | ProgramName | NoOfclasses |
      |     ci/cd      | Test009          | LMSprogram  |            |

  @BatchPage-26
  Scenario Outline: Check if description field is optional in update
    Given Admin clicks the edit icon after landing on batchpage
    When Update the fields "<BatchName>","< BatchDescription>","<ProgramName>" and "<NoOfclasses>" with no description click save
    Then The updated batch details should appear on the data table

    Examples: 
      | BatchName | BatchDescription | ProgramName | NoOfclasses |
      | OOPS05    |                  | LMSprogram  |           4 |
   
   