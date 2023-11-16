package com.srs.backend.constant;

public class AbstractConstant {

	public static final String LANGUAGE = "en";
	public static final String COUNTRY = "TR";
	/**
	 * Abstract Persistence Constants
	 */
	public static final long DEFAULT_ID_UNSAVED_VALUE = 0L;
	public static final Long ID_UNSAVED_VALUE = null;
	public static final String ID_COLUMN_NAME = "id";
	public static final String VERSION_COLUMN_NAME = "version";
	public static final String ACTIVE_COLUMN_NAME = "is_active";
	public static final String CREATED_BY_COLUMN_NAME = "created_by";
	public static final String LAST_UPDATED_BY_COLUMN_NAME = "last_updated_by";
	public static final String CREATION_DATE_COLUMN_NAME = "creation_date";
	public static final String LAST_UPDATED_DATE_COLUMN_NAME = "last_updated_date";
	/**
	 * Abstract Table Constants
	 */
	public static final String TABLE_PREFIX = "parcel_";
	public static final String SLOT_DIMENSION_TABLE_NAME = TABLE_PREFIX + "slot_dimension";
	public static final String SLOT_TYPE_TABLE_NAME = TABLE_PREFIX + "slot_type";
	public static final String SLOT_TYPE_SENSOR_TABLE_NAME = TABLE_PREFIX + "slot_type_sensor";
	public static final String MERCHANT_TABLE_NAME = TABLE_PREFIX + "merchant";
	public static final String PARCEL_LOCKER_TABLE_NAME = TABLE_PREFIX + "locker";
	public static final String MODULE_TABLE_NAME = TABLE_PREFIX + "locker_module";
	public static final String SLOT_TABLE_NAME = TABLE_PREFIX + "locker_slot";

	public static final String SETTINGS_TABLE_NAME= TABLE_PREFIX+"general_settings";
	public static final String PARAM_MAP_TABLE_NAME = TABLE_PREFIX + "schedule_mapping";

	public static final String MESSAGE_QUEUE_TABLE_NAME = TABLE_PREFIX + "message_queue";

	public static final String PARCEL_LOCKER_MODULE_BOX_SENSOR_TABLE_NAME = TABLE_PREFIX + "sensor";
	public static final String COMPANY_TABLE_NAME = TABLE_PREFIX + "company";
	public static final String ABSTRACT_USER_TABLE_NAME = TABLE_PREFIX + "user";
	public static final String CONFIGURATION_TABLE_NAME = TABLE_PREFIX + "locker_configuration";
	public static final String PARCEL_LOCKER_TEMPLATE_TABLE_NAME = TABLE_PREFIX + "definition_pl_template";
	public static final String PARCEL_LOCKER_TEMPLATE_MODULE_TEMPLATE_TABLE_NAME = TABLE_PREFIX + "definition_pl_template_module_template";
	public static final String MODULE_TEMPLATE_TABLE_NAME = TABLE_PREFIX + "definition_module_template";
	public static final String MODULE_TEMPLATE_SLOT_TYPE_TABLE_NAME = TABLE_PREFIX + "definition_module_template_slot_type";

	public static final String AUTHORITY_TABLE_NAME = TABLE_PREFIX + "system_authority";
	public static final String ROLE_TABLE_NAME = TABLE_PREFIX + "user_role";
	public static final String AUTHORITIES_TABLE_NAME = TABLE_PREFIX + "system_authorities";

	public static final String USER_TABLE_NAME = TABLE_PREFIX + "system_user";
	public static final String COUNTRY_TABLE_NAME = TABLE_PREFIX + "system_country";
	public static final String CITY_TABLE_NAME = TABLE_PREFIX + "system_city";
	public static final String DISTRICT_TABLE_NAME = TABLE_PREFIX + "system_district";
	public static final String ADDRESS_TABLE_NAME = TABLE_PREFIX + "system_address";

	public static final String DEFINITION_TABLE_NAME = TABLE_PREFIX + "system_definition";
	public static final String DEFAULT_EVENT_PARCEL_LOCKER_TABLE_NAME = TABLE_PREFIX + "event_locker";

	public static final String DEFAULT_EVENT_ABSTRACT_TABLE_NAME = TABLE_PREFIX + "event_abstract";
	public static final String DEFAULT_COMMAND_ABSTRACT_TABLE_NAME = TABLE_PREFIX + "schedule_command";
	public static final String DEFAULT_COMMAND_ABSTRACT_METADATA_TABLE_NAME = TABLE_PREFIX + "schedule_command_data";

	public static final String DEFAULT_COMMAND_PARCEL_LOCKER_TABLE_NAME = TABLE_PREFIX + "command_locker";
	public static final String DEFAULT_KEY_VALUE_MAP_TABLE_NAME = AbstractConstant.TABLE_PREFIX+"schedule_mapping_value";
}