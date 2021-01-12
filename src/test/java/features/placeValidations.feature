Feature: Validating Place API's

@addPlace
Scenario Outline: Verify if place is being successfully added using addPlaceAPI

Given add Place Payload with "<name>" "<language>" "<address>"
When user calls "addPlaceAPI" with "Post" http request
Then the API call is success with status code 200
And "status" in responce body is "OK"
And "scope" in responce body is "APP"
And verify place_Id created maps to "<name>" using "getPlaceAPI"


Examples:
	| name        | language    | address      |
	| MyHouse     | English     | WordCenter 1 |
#	| ParentHouse | Russian     | Sain 1       |


@deletePlace
Scenario: Verify if Delete Place functionality is working

Given DeletePlace Payload
When user calls "deletePlaceAPI" with "DELETE" http request
Then the API call is success with status code 200
And "status" in responce body is "OK"
