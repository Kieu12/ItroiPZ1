package ua.nure.parser;

import ua.nure.entity.ObjectFactory;

public interface Const {
	String TAG_TICKET = "Ticket";
	String TAG_AIRPLANETITLE = "Airplane_Title";
	String TAG_DURATION = "Duration";
	String TAG_DESTINATION = "Destination";
	String TAG_TICKETNUMBER = "Ticket_Number";
	String TAG_SEATNUMBER = "Seat_Number";
	String TAG_PURCHASEDATE = "Purchase_Date";
	String TAG_PASSENGER = "Passenger";
	String TAG_NAME = "Name";
	String TAG_SURNAME = "Surname";
	String TAG_AIRPLANE = "Airplane";
	String TAG_AIRPLANES = "Airplanes";
	String AIRPLANES_NAMESPACE_URI = "http://nure.ua/entity";
	String ATTRIBUTE_ID = "Id";


	String XML_FILE = "xml/Airplanes.xml";
	String INVALID_XML_FILE = "xml/Invalid_airplanes.xml";
	String XSD_FILE = "xml/Airplanes.xsd";
	Class<?> OBJECT_FACTORY = ObjectFactory.class;

	String SCHEMA_LOCATION__ATTR_NAME = "schemaLocation";
	String SCHEMA_LOCATION__ATTR_FQN = "xsi:schemaLocation";
	String XSI_SPACE__PREFIX = "xsi";
	String SCHEMA_LOCATION__URI = "http://nure.ua/entity Airplanes.xsd";

	// validation features
	public static final String FEATURE__TURN_VALIDATION_ON =
			"http://xml.org/sax/features/validation";
	public static final String FEATURE__TURN_SCHEMA_VALIDATION_ON =
			"http://apache.org/xml/features/validation/schema";

}
