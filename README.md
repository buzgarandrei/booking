A back-end that implements a book traveling system. In the "Search" request you set the dates, number of people you go with and the place and it will output the list of all rooms made available by all hotels from the searched city, with all the facilities and descriptions of the room, hotel that it belongs and facilities.
# 
Copy the json bellow, open Postman, click the Import button , and look for Paste Row Text, there you will paste the json and you will get the collection of http requests of this app.
#
{
	"id": "bf734537-8347-4b45-91c2-8057ac5ea4d4",
	"name": "Booking",
	"description": "",
	"auth": null,
	"events": null,
	"variables": [],
	"order": [
		"14f0ac22-a43b-4974-8d80-c8d03c89b193",
		"a1063628-d940-47d9-abe9-3e302c668ad9",
		"968f4995-05af-4a90-9978-445e677e92a4",
		"f0af8f00-164b-4ff7-9978-bac603a0f6b8",
		"8e5cbdf4-3d53-4317-9ccf-3dc132d949ba",
		"0328d0d6-4b3b-4e80-99bd-105878bebebf",
		"6cb0eb89-3fae-49c4-9ac6-14f00c0d442d",
		"56c81ef7-aed2-4552-9dbb-c5c68da0692b",
		"d1a7855f-7214-4db2-b625-1e84111fa026",
		"85fada03-dda1-471a-95f6-cf818f3539ca",
		"06c7ac74-6191-46d7-a511-9a82dba3ef2c",
		"f2d35582-8b86-4a38-bafc-1b151cbbb596",
		"6fb386cd-2816-44c5-af25-638a6ef58812",
		"4d3e52d4-c97c-4d70-8b74-80d46bf1c6be",
		"6c1ea944-4874-43c6-b224-066fa9374e6c",
		"01340f51-a5f9-46a3-bcbb-1a79782af473",
		"e8c894ba-5645-4f80-a79d-d201ef49843b",
		"18af4be3-6401-4fbb-9a86-042110eaf57c",
		"d10a5baf-bca9-4db4-8be7-a82d8d161006",
		"e10d9cb0-0150-40cc-8979-0aadc559ecf0",
		"879fbdf6-b7f1-4fdb-b083-333652e8185a",
		"0c28bed8-9ca1-4ed3-8197-7f7cbd393c73",
		"47a3b260-49e5-4e41-8ec2-df3d2787279e",
		"e58472f3-bc41-43cb-8313-fc77b2a5d588",
		"6fb5eadb-ac8e-4c24-89a6-ceb3f2be9332",
		"d15a5d3c-e689-4283-99b5-6af43b1f07cc",
		"7316d244-2318-47bb-8f2b-6e548f482795",
		"618e7faf-094d-4104-97aa-405e5bbfe256",
		"9d62da41-d43f-40d7-8846-3756356d3b6e",
		"06cbb254-c89f-4db2-9c57-5897e650c4d3",
		"3beedc32-92a8-4e58-8355-9c2893ee7104",
		"a574d2ed-8c84-4153-b40b-eaae1a1278a7",
		"1f0cd83c-5ec4-44b2-b33b-0ab54c40dee0",
		"5f9c81be-f1b0-4e1c-8a9c-00c6743f4556",
		"a511acd1-4588-4b16-b133-d67da10ea55b",
		"ea218ea3-a380-40c7-90c2-0203c3c2bb93",
		"a33d7154-c048-4330-90aa-0b76d6a71a1f",
		"19142442-d851-42f7-8711-ab16cddedcfb",
		"ec27e17f-1622-4746-acac-8f8003202cd2",
		"d3a061a3-3eee-47ca-875d-8b5aae8d056e",
		"858d5ff3-ed87-4e77-8166-421eb0b25ca2",
		"79b2d2d2-6212-419b-9e87-6fb0f1ec3a63",
		"944de819-5be6-4e9b-8f9d-d63ff3faa746",
		"999ed666-ddc6-41e7-a98e-f37ff79e8566",
		"55e4b201-5efe-4dab-88e0-46cd694323a9",
		"71950118-d225-43e9-8770-c12d97ab386c",
		"78a51899-d369-475a-8851-f93fcccec52f",
		"57fa7983-1cb2-4ae8-90cd-04d0d7bc91fb",
		"e392369b-d43f-4eba-a05e-2ac18f2b343f",
		"88034f67-b224-4e03-baa7-6ce77bfa10fe",
		"1bd540db-3a8f-4947-bf0b-8758d90a850c",
		"0c3fbf1b-e584-4f06-8006-d8239e703eb1",
		"95817ae7-c7c8-44c2-bbba-69e9a1c68bf4",
		"da38972f-acde-40f1-8603-6aa25f03c5c5",
		"ab27ad9f-8854-49fa-a4e2-6edd44803bb0",
		"d8b83afe-d7be-44e5-b320-22d97b83913c",
		"b35688ec-65b7-4054-bd97-efc911d42ae7",
		"0d5fcace-1cce-4ee2-9fed-8679fc9173e1",
		"b849f462-d7f7-49a9-9de1-b34eaca7a68f",
		"7dff0904-1d94-4290-8a92-3e03783ec73a"
	],
	"folders_order": [],
	"protocolProfileBehavior": {},
	"folders": [],
	"requests": [
		{
			"id": "01340f51-a5f9-46a3-bcbb-1a79782af473",
			"name": "Get Descriptions Of A Hotel",
			"url": "http://localhost:8080/getDescriptionsOfAHotel",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"rawModeData": "{\n\t\"id\" : \"1\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "0328d0d6-4b3b-4e80-99bd-105878bebebf",
			"name": "Get Offers",
			"url": "http://localhost:8080/getOffers",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "06c7ac74-6191-46d7-a511-9a82dba3ef2c",
			"name": "Get Hotel Descriptions",
			"url": "http://localhost:8080/getHotelDescriptions",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "06cbb254-c89f-4db2-9c57-5897e650c4d3",
			"name": "Add Room Description",
			"url": "http://localhost:8080/addRoomDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": " {\r\n        \"roomDescriptionType\": \"DESCRIPTION\",\r\n        \"roomId\": 2,\r\n        \"descriptionId\": 5\r\n    }",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "0c28bed8-9ca1-4ed3-8197-7f7cbd393c73",
			"name": "login",
			"url": "http://localhost:8080/addUser",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"name\" : \"Buzgar Andrei\",\n\t\"email\" : \"buzgarandrei@gmail.com\",\n\t\"password\" : \"123\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "0c3fbf1b-e584-4f06-8006-d8239e703eb1",
			"name": "Delete Room Description",
			"url": "http://localhost:8080/deleteRoomDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"4\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "0d5fcace-1cce-4ee2-9fed-8679fc9173e1",
			"name": "Make Owner",
			"url": "http://localhost:8080/makeOwner",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"1\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "14f0ac22-a43b-4974-8d80-c8d03c89b193",
			"name": "search",
			"url": "http://localhost:8080/search",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"rawModeData": "{ \n\t\"cityName\" : \"Cluj-Napoca\",\n    \"nrOfAdults\" : \"2\",\n    \"nrOfKids\" : \"2\",\n    \"language\" : \"EN\",\n    \"dateStart\" : \"2019-12-17\",\n    \"dateEnd\" : \"2020-01-02\"\n\t\n}\t",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "18af4be3-6401-4fbb-9a86-042110eaf57c",
			"name": "Get List Of All Beds",
			"url": "http://localhost:8080/getListOfAllBeds",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "19142442-d851-42f7-8711-ab16cddedcfb",
			"name": "Update Bed Type",
			"url": "http://localhost:8080/updateBedType",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"3\",\n\t\"noOfPersons\" : \"4\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "1bd540db-3a8f-4947-bf0b-8758d90a850c",
			"name": "Delete Room",
			"url": "http://localhost:8080/deleteRoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"4\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "1f0cd83c-5ec4-44b2-b33b-0ab54c40dee0",
			"name": "Add Offer",
			"url": "http://localhost:8080/addBedToARoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\r\n        \"noOfBeds\": 2,\r\n        \"roomId\": 2,\r\n        \"bedTypeId\": 1\r\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "3beedc32-92a8-4e58-8355-9c2893ee7104",
			"name": "Add Room Facility",
			"url": "http://localhost:8080/addRoomFacility",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id1\" : \"1\",\n\t\"id2\" : \"2\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "47a3b260-49e5-4e41-8ec2-df3d2787279e",
			"name": "Add Hotel",
			"url": "http://localhost:8080/addHotel",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"name\" : \"Grand Hotel Italia\",\n\t\"city\" : \"Cluj-Napoca\",\n\t\"idRegion\" : \"14535467897654\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "4d3e52d4-c97c-4d70-8b74-80d46bf1c6be",
			"name": "Get Room Descriptions",
			"url": "http://localhost:8080/getRoomDescriptions",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "55e4b201-5efe-4dab-88e0-46cd694323a9",
			"name": "Delete Hotel",
			"url": "http://localhost:8080/deleteHotel",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"5\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "56c81ef7-aed2-4552-9dbb-c5c68da0692b",
			"name": "Get Prices",
			"url": "http://localhost:8080/getPrices",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "57fa7983-1cb2-4ae8-90cd-04d0d7bc91fb",
			"name": "Delete Bed Type",
			"url": "http://localhost:8080/deleteBedType",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"3\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "5f9c81be-f1b0-4e1c-8a9c-00c6743f4556",
			"name": "Update User",
			"url": "http://localhost:8080/updateUser",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\t\"id\" : \"2\",\n\t\"email\" : \"muci@gmail.com\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "618e7faf-094d-4104-97aa-405e5bbfe256",
			"name": "Add Hotel Facility",
			"url": "http://localhost:8080/addHotelFacility",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id1\" : \"1\",\n\t\"id2\" : \"3\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "6c1ea944-4874-43c6-b224-066fa9374e6c",
			"name": "Get Descriptions Of A Room",
			"url": "http://localhost:8080/getDescriptionsOfARoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"rawModeData": "{\n\"id\" : \"2\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "6cb0eb89-3fae-49c4-9ac6-14f00c0d442d",
			"name": "Get Rooms",
			"url": "http://localhost:8080/getRooms",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [
				{
					"key": "TOKEN",
					"value": "54fa12d9e22b434cb4aec48e2c56d9c0",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "TOKEN: 54fa12d9e22b434cb4aec48e2c56d9c0\n",
			"pathVariables": {}
		},
		{
			"id": "6fb386cd-2816-44c5-af25-638a6ef58812",
			"name": "Get Rooms",
			"url": "http://localhost:8080/getRooms",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "6fb5eadb-ac8e-4c24-89a6-ceb3f2be9332",
			"name": "Add Description",
			"url": "http://localhost:8080/addDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"text\" : \"Aceatsa e o descriere noua\"\n\t\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "71950118-d225-43e9-8770-c12d97ab386c",
			"name": "Delete Facility",
			"url": "http://localhost:8080/deleteFacility",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"5\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "7316d244-2318-47bb-8f2b-6e548f482795",
			"name": "Add Hotel Description",
			"url": "http://localhost:8080/addHotelDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"hotelDescriptionType\" : \"DESCRIPTION\",\n    \"hotelId\" : \"2\",\n    \"descriptionId\" : \"6890843789407265\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "78a51899-d369-475a-8851-f93fcccec52f",
			"name": "Delete Description",
			"url": "http://localhost:8080/deleteDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"11\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "79b2d2d2-6212-419b-9e87-6fb0f1ec3a63",
			"name": "Update Bed Of A Room",
			"url": "http://localhost:8080/updateBedOfARoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\r\n        \"id\": 2,\r\n        \"noOfBeds\": 1,\r\n        \"roomId\": 567,\r\n        \"bedTypeId\": 274983026\r\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "7dff0904-1d94-4290-8a92-3e03783ec73a",
			"name": "Make Appointment",
			"url": "http://localhost:8080/makeAppointment",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"userId\" : \"1\",\n\t\"roomId\" : \"1\",\n\t\"startDate\": \"2019-12-21\",\n    \"endDate\": \"2020-01-02\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "858d5ff3-ed87-4e77-8166-421eb0b25ca2",
			"name": "Update Room Description",
			"url": "http://localhost:8080/updateRoomDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\r\n        \"id\": 4,\r\n        \"roomDescriptionType\": \"DESCRIPTION\",\r\n        \"roomId\": 2,\r\n        \"descriptionId\": 5\r\n    }",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "85fada03-dda1-471a-95f6-cf818f3539ca",
			"name": "Get Bed Types",
			"url": "http://localhost:8080/getBedTypes",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "879fbdf6-b7f1-4fdb-b083-333652e8185a",
			"name": "Add User",
			"url": "http://localhost:8080/addUser",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\t\"id\" : \"1\",\n\t\"name\" : \"Buzgar Andrei\",\n\t\"email\" : \"buzgarandrei@gmail.com\",\n\t\"password\" : \"123\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "88034f67-b224-4e03-baa7-6ce77bfa10fe",
			"name": "Delete Hotel Facility",
			"url": "http://localhost:8080/deleteHotelFacility",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id1\" : \"1\",\n\t\"id2\" : \"3\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "8e5cbdf4-3d53-4317-9ccf-3dc132d949ba",
			"name": "Get Facilities",
			"url": "http://localhost:8080/getFacilities",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "944de819-5be6-4e9b-8f9d-d63ff3faa746",
			"name": "Update Offer",
			"url": "http://localhost:8080/updateBedOfARoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\r\n        \"id\": 2,\r\n        \"noOfBeds\": 1,\r\n        \"roomId\": 567,\r\n        \"bedTypeId\": 274983026\r\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "95817ae7-c7c8-44c2-bbba-69e9a1c68bf4",
			"name": "Delete Room Facility",
			"url": "http://localhost:8080/deleteRoomFacility",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id1\" : \"1\",\n\t\"id2\" : \"2\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "968f4995-05af-4a90-9978-445e677e92a4",
			"name": "Get Users",
			"url": "http://localhost:8080/getUsers",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [
				{
					"key": "REQUEST_HEADER_TOKEN",
					"value": "95a5d7adf18042df8769cfd56c1dfd38",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "REQUEST_HEADER_TOKEN: 95a5d7adf18042df8769cfd56c1dfd38\n",
			"pathVariables": {}
		},
		{
			"id": "999ed666-ddc6-41e7-a98e-f37ff79e8566",
			"name": "Delete User",
			"url": "http://localhost:8080/deleteUser",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"2\"\n\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "9d62da41-d43f-40d7-8846-3756356d3b6e",
			"name": "Add Room",
			"url": "http://localhost:8080/addRoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"nrOfAdults\" : \"11\",\n   \n    \"idHotel\" : \"2\",\n    \"available\" : \"true\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "a1063628-d940-47d9-abe9-3e302c668ad9",
			"name": "populate",
			"url": "http://localhost:8080/Run",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "a33d7154-c048-4330-90aa-0b76d6a71a1f",
			"name": "Update Description",
			"url": "http://localhost:8080/updateDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"11\",\n\t\"text\" : \"Aceasta e o descriere noua si updatata\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "a511acd1-4588-4b16-b133-d67da10ea55b",
			"name": "Update Hotel",
			"url": "http://localhost:8080/updateHotel",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"3\",\n\t\"name\" : \"grand hotel italia\",\n\t\"city\" : \"cluj-napoca\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "a574d2ed-8c84-4153-b40b-eaae1a1278a7",
			"name": "Add Bed To A Room",
			"url": "http://localhost:8080/addBedToARoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\r\n        \"noOfBeds\": 2,\r\n        \"roomId\": 2,\r\n        \"bedTypeId\": 1\r\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "ab27ad9f-8854-49fa-a4e2-6edd44803bb0",
			"name": "Delete Facility Description",
			"url": "http://localhost:8080/deleteFacilityDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id1\" : \"2\",\n\t\"id2\" : \"4\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "b35688ec-65b7-4054-bd97-efc911d42ae7",
			"name": "Make Admin",
			"url": "http://localhost:8080/makeAdmin",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"1\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "b849f462-d7f7-49a9-9de1-b34eaca7a68f",
			"name": "Make Premium User",
			"url": "http://localhost:8080/makePremiumUser",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"1\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "d10a5baf-bca9-4db4-8be7-a82d8d161006",
			"name": "Get Beds Of A Room",
			"url": "http://localhost:8080/getBedsOfARoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"rawModeData": "{\n\t\"id\" : \"1\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "d15a5d3c-e689-4283-99b5-6af43b1f07cc",
			"name": "Add Bed Type",
			"url": "http://localhost:8080/addBedType",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"kindOfBed\" : \"KINGSIZE\",\n    \"noOfPersons\" : \"3\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "d1a7855f-7214-4db2-b625-1e84111fa026",
			"name": "Get Descriptions",
			"url": "http://localhost:8080/getDescriptions",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "d3a061a3-3eee-47ca-875d-8b5aae8d056e",
			"name": "Update Room",
			"url": "http://localhost:8080/updateRoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"3\",\n\t\"nrOfAdults\" : \"1\",\n   \"nrOfKids\" : \"1\",\n    \"idHotel\" : \"2\",\n    \"available\" : \"true\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "d8b83afe-d7be-44e5-b320-22d97b83913c",
			"name": "Delete Offer",
			"url": "http://localhost:8080/deleteFacilityDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id1\" : \"2\",\n\t\"id2\" : \"4\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "da38972f-acde-40f1-8603-6aa25f03c5c5",
			"name": "Delete Bed Of A Room",
			"url": "http://localhost:8080/deleteBedOfARoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"name": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"2\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "e10d9cb0-0150-40cc-8979-0aadc559ecf0",
			"name": "Get Rooms Of A Hotel",
			"url": "http://localhost:8080/getBedsOfARoom",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"rawModeData": "{\n\t\"id\" : \"1\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "e392369b-d43f-4eba-a05e-2ac18f2b343f",
			"name": "Delete Hotel Description",
			"url": "http://localhost:8080/deleteHotelDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"4\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "e58472f3-bc41-43cb-8313-fc77b2a5d588",
			"name": "Add Facility",
			"url": "http://localhost:8080/addFacility",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"facilityType\" : \"HOTEL\",\n\t\"facilityName\" : \"ENUM\",\n\t\"svg\" : \"svg 4\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "e8c894ba-5645-4f80-a79d-d201ef49843b",
			"name": "Get Room Facilities",
			"url": "http://localhost:8080/getRoomFacilities",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"rawModeData": "{\n\t\"id\" : \"1\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "ea218ea3-a380-40c7-90c2-0203c3c2bb93",
			"name": "Update Facility",
			"url": "http://localhost:8080/updateFacility",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"4\",\n\t\"facilityType\" : \"HOTEL\",\n\t\"facilityName\" : \"ENUM/MMMM\",\n\t\"svg\" : \"svg 4\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "ec27e17f-1622-4746-acac-8f8003202cd2",
			"name": "Update Hotel Description",
			"url": "http://localhost:8080/updateHotelDescription",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"description": "",
					"enabled": true,
					"key": "Content-Type",
					"type": "text",
					"value": "application/json"
				}
			],
			"method": "POST",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"rawModeData": "{\n\t\"id\" : \"3\",\n\t\"hotelDescriptionType\" : \"DESCRIPTION\",\n    \"hotelId\" : \"2\",\n    \"descriptionId\" : \"10000\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		},
		{
			"id": "f0af8f00-164b-4ff7-9978-bac603a0f6b8",
			"name": "Get Hotels",
			"url": "http://localhost:8080/getHotels",
			"description": "",
			"data": null,
			"dataOptions": null,
			"dataMode": null,
			"headerData": [],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"headers": "",
			"pathVariables": {}
		},
		{
			"id": "f2d35582-8b86-4a38-bafc-1b151cbbb596",
			"name": "Get Hotel Facilities",
			"url": "http://localhost:8080/getHotelFacilities",
			"description": "",
			"data": [],
			"dataOptions": null,
			"dataMode": "raw",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"type": "text",
					"enabled": true
				}
			],
			"method": "GET",
			"pathVariableData": [],
			"queryParams": [],
			"auth": null,
			"events": [],
			"folder": null,
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"rawModeData": "{\n\"id\" : \"1\"\n}",
			"headers": "Content-Type: application/json\n",
			"pathVariables": {}
		}
	]
}
"# booking" 
