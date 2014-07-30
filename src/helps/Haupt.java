package helps;

public class Haupt {
	
	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	public static final String DATABASE_NAME = "InternalSmilerDB";
	// Table name
	public static final String TABLE_ENTITY = "entityTable";
	// Table Columns names
	//private static final String ENTRY_ID = "entry_id";
	public static final String UUID = "uuid";						
	public static final String DESCRIPTION = "description";
	public static final String RATING = "rating";
	public static final String HOMEPAGE = "homepage";
	public static final String PHONE_NUMBER = "phone_number";
	public static final String LABEL = "label";
	public static final String COUNTRY = "country";
	public static final String POSTAL_CODE = "postal_code";
	public static final String CITY = "city";
	public static final String STREET = "street";
	public static final String STREET_NR = "street_nr";
	public static final String LAT_COORDINATE = "lat_coordinate";
	public static final String LON_COORDINATE = "lon_coordinate";
	public static final String ADDITIONAL_INFO = "additional_info";
	public static final String OPENING_HOURS = "opening_hours";
	public static final String START_TIME = "start_time";
	public static final String HASHED_OLD_VALUE = "hashed_old_value";
	public static final String DEVICE_ID = "device_id";
	public static final String CATEGORY = "category";
	public static final String TYPE = "type";
	public static final String END_TIME = "end_time";
	public static final String IS_FAVORITE = "is_favorite";
	public static final String IS_MYEVENT = "is_myevent";
	public static final String MARKER = "marker";
	public static final String SRC = "source";
	public static final String INTID = "intid";
	
	public static final String SCHEDID = "scheduleID";
	public static final String DAYOFWEEK = "dayOfWeek";
	public static final String TIMEOPEN = "timeOpen";
	public static final String TIMECLOSE = "timeClose";
	public static final String LOCID = "locationID";
	public static final String TABLE_SCHEDULE = "schedule";
	public static String gitti = "gitti";
	
	public static void main(String[] args)
	{
		
		String Create_Entity_table = "CREATE TABLE table1 ("
				+ UUID + " TEXT, "
				+ DESCRIPTION + " TEXT NOT NULL, " + RATING + " DECIMAL(4,0), "
				+ HOMEPAGE + " TEXT, " + PHONE_NUMBER + " VARCHAR(20), " + LABEL
				+ " VARCHAR(75), " + COUNTRY + " TEXT, " + POSTAL_CODE
				+ " VARCHAR(11), " + CITY + " TEXT, " + STREET
				+ " VARCHAR(75), " + STREET_NR + " INTEGER(11), "
				+ LAT_COORDINATE + " TEXT NOT NULL, " + LON_COORDINATE + " TEXT NOT NULL, "
				+ ADDITIONAL_INFO + " TEXT, " + OPENING_HOURS + " TEXT, "
				+ START_TIME + " DATETIME, " + HASHED_OLD_VALUE + " TEXT, "
				+ DEVICE_ID + " INT(11), " + CATEGORY + " VARCHAR(75), " + TYPE
				+ " VARCHAR(75), " + END_TIME + " DATETIME, "
				+ IS_FAVORITE +" INTEGER(1), "
				+ IS_MYEVENT +" INTEGER(1), "  
				+ "PRIMARY KEY("+DESCRIPTION+", "+LAT_COORDINATE+", "+LON_COORDINATE+")) ";
		
		System.out.println(Create_Entity_table);
	
		
		String Create_Schedule_table = "CREATE TABLE "+TABLE_SCHEDULE+" ("
				+ SCHEDID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + DAYOFWEEK +" INTEGER(11), "
				+ TIMEOPEN +" VARCHAR(5), " + TIMECLOSE + " VARCHAR(5), "
				+ LOCID +" INT(11), FOREIGN KEY("+LOCID+") REFERENCES "+ TABLE_ENTITY +"("+INTID+"))";
		
		
		System.out.println(Create_Schedule_table);
		
		String schedStr = "{Mon=[03:00 - 04:00, 09:00 - 06:00], Tue=[09:00 - 06:00], Wed=[09:00 - 06:00], Thu=[09:00 - 06:00], Fri=[09:00 - 06:00], Sat=[09:00 - 06:00], Sun=[09:00 - 04:00]}";
		
		//String[] singleDays = schedStr.split(",");
		
		//System.out.println(singleDays[0]);
		//System.out.println(singleDays[1]);
		
		String monRaw = schedStr.substring(0, schedStr.indexOf("Tue"));
		monRaw = monRaw.substring(6, monRaw.length()-3);
		
		String[] monTimeRanges = monRaw.split(", ");
		for (int i = 0; i<monTimeRanges.length; i++)
		{
			String[] singleTimes = monTimeRanges[i].split(" - ");
			if (singleTimes.length==2)
			{
			String startTime = singleTimes[0];
			String endTime = singleTimes[1];
			}
			//Insert (null, 1, startTime, endTime, locId)
			
		}
		
		String tueRaw = schedStr.substring(schedStr.indexOf("Tue")+5, schedStr.indexOf("Wed")-3);
		String tueRanges[] = tueRaw.split(", ");
		for (int i = 0; i<tueRanges.length; i++)
		{
			String[] singleTimes = tueRanges[i].split(" - ");
			if (singleTimes.length==2)
			{
			String startTime = singleTimes[0];
			String endTime = singleTimes[1];
			}
		}
		
		
		
		
		System.out.println(tueRaw);
		
		
		
	}
	
	public static String[] getStartEndForDay(String dayClean)
	{
		String[] dayRanges = dayClean.split(", ");
		for (int i = 0; i<dayRanges.length; i++)
		{
			String[] singleTimes = dayRanges[i].split(" - ");
			if (singleTimes.length==2)
			{
				return singleTimes;
			}
		}
		return null;
	}
}
