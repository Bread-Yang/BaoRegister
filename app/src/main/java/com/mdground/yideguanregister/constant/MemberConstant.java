package com.mdground.yideguanregister.constant;

/**
 * 成员常量，类中的常量。
 *
 * @author Administrator
 */
public class MemberConstant {
    public static final int BASIC_INFO_CODE = 0;
    public static final int RECORD_INFO_CODE = 1;
    public static final int Medicine_INFO_CODE = 2;

    public static final String UPDATE_TICKS = "update_ticks";

    /**
     * 控制滑动事件分发使用的常量
     **/
    public static final String SHOW_FRAGMENT_PAGE = "showFragment";
    public static final String SHOW_LIST_COUNT = "showCount";

    /**
     * 打开左侧菜单
     **/
    public static final int OPEN_LEFT_MENU = 1001;

    public static final String ROLE_TYPE = "roleType";

    /**
     * 医生角色
     **/
    public static final String DOCTOR = "doctor";
    public static final String DOCTOR_ID = "doctorId";
    public static final String DOCTOR_ROLE = "doctorRole";
    public static final String DOCTOR_Name = "doctorName";
    public static final String DOCTOR_EMR = "doctorEmr";
    public static final String DOCTOR_LIST = "doctorList";
    /**
     * 症状
     */
    public static final String SYMPTOM_LIST = "symptomList";
    public static final String SYMPTOM_REMARK = "symptomRemark";

    /**
     * 护士角色
     **/
    public static final String NURSE_ROLE = "nurse";

    public static final String PATIENT = "patient";
    public static final String PATIENT_ID = "patient_id";
    public static final String PATIENT_NAME = "patientName";

    /**
     * 找回密码，startActivityForResult中使用的参数
     */
    public static final String PHONE = "phone";

    // 用户二维码
    public static final String EMPLOYEE_QRCODE = "employee_qrcode";
    public static final String EMPLOYEE_PHOTO_URL = "employee_photo_url";
    public static final String EMPLOYEE_NAME = "employee_name";
    public static final String EMPLOYEE_CLINIC_NAME = "employee_clinic_name";
    public static final String EMPLOYEE_GENDER = "employee_gender";
    public static final String EMPLOYEE_UPDATE = "updateCode";
    public static final String EMPLOYEE_ID = "employee_id";
    public static final String EMPLOYEE_ROLE = "employee_role";

    // 医生候诊大厅
    public static final int APPIONTMENT_RESULT_PASS = 2;// 过号
    public static final int APPIONTMENT_RESULT_ASSIGN = 4;// 分配
    public static final int APPOINTMENT_RESUTL_SETTLEMENT = 4; // 结算

    public static final String APPOINTMENT_STATUS = "appointment_status";
    public static final String APPOINTMENT_NO = "appointment_no";
    public static final String APPOINTMENT_ID = "appointment_id";
    public static final String APPOINTMENT = "appointment";
    public static final String APPOINTMENT_CALL_NEXT = "appointment_call_next";
    public static final String APPOINTMENT_LIST = "appointment_list";
    public static final String APPOINTMENT_LIST_INDEX = "appointment_list_index";

    public static final String APPOINTMENT_CHIEF_COMPLAINT = "appointment_chief_complaint";
    public static final String APPOINTMENT_PRESENT_ILLNESS = "appointment_present_illness";
    public static final String APPOINTMENT_VITAL_SIGNS = "appointment_vital_signs";
    public static final String APPOINTMENT_DIAGNOSIS_ADD_TEMPLATE = "appointment_diagnosis_add_template";
    public static final String APPOINTMENT_DIAGNOSIS_LIST = "appointment_diagnosis_list";
    public static final String APPOINTMENT_DRUG_USE_EDIT = "appointment_drug_use_edit";
    public static final String PRESCRIPTION_DRUG_DETAIL = "prescription_drug_detail";
    public static final String PRESCRIPTION_DRUG_USE = "prescription_drug_use";
    public static final String PRESCRIPTION_IS_CHINESE_PRESCRIPTION = "prescription_is_chinese_prescription";
    public static final String APPOINTMENT_APPOINTMENT_INFO = "appointment_appointment_info";
    public static final String APPOINTMENT_OFFICE_VISIT_INFO = "appointment_office_visit_info";
    public static final String APPOINTMENT_ANAMNESIS_LIST = "appointment_anamnesis_list";
    public static final String APPOINTMENT_ANAMNESIS_FROM_WAITING = "appointment_anamnesis_from_waiting";
    public static final String APPOINTMENT_ANAMNESIS_FROM_PATIENT_DETAIL = "appointment_anamnesis_from_patient_detail";
    public static final String ANAMNESIS_APPOINTMENT = "anamnesis_appointment";
    public static final String ANAMNESIS_APPOINTMENT_ID = "anamnesis_appointment_id";

    // 收银
    public static final String CASHIER_BILLING_DETAIL = "cashier_billing_detail";
    public static final String CASHIER_OFFICE_VISIT_INFO = "CASHIER_OFFICE_VISIT_INFO";
    public static final String CASHIER_PATIENT = "cashier_patient";
    public static final String SETTLEMENT_IS_ALREADY_PAID = "settlement_is_already_paid";
    public static final String SETTLEMENT_IS_HISTORY_PAID = "settlement_is_history_paid";
    public static final String SETTLEMENT_BY_CASH = "settlement_by_cash";
    public static final String SETTLEMENT_METHOD = "settlement_method";

    public static final String SETTLEMENT_RECEIVABLE = "settlement_receivable";

    // 门诊统计
    public static final String DOCTOR_STATISTICS_SELECTED_DOCTOR = "doctor_statistics_selected_doctor";
    public static final String DOCTOR_STATISTICS_DOCTOR_LIST = "doctor_statistics_doctor_list";
    public static final String DOCTOR_STATISTICS_DATE = "doctor_statistics_date";
    public static final String DOCTOR_STATISTICS_START_DATE = "doctor_statistics_start_date";
    public static final String DOCTOR_STATISTICS_END_DATE = "doctor_statistics_end_date";
    public static final String DOCTOR_STATISTICS_DOCTOR_ID= "doctor_statistics_doctor_id";
    public static final String DOCTOR_SHOW_MODULE_INT = "doctor_show_module_int";
    public static final String DOCTOR_STATISTICS_DURATION = "doctor_statistics_duration";

    // 药房统计
    public static final String PHARMACY_STATISTICS_RANKING_TYPE = "PHARMACY_STATISTICS_RANKING_TYPE";

    // 既往史
    public static final String ANAMNESIS_FROM_ACTIVITY = "anamnesis_from_activity";
    public static final int FROM_PATIENT_APPOINTMENT = 1;
    public static final int FROM_PATIENT_DETAIL = 2;
    public static final int FROM_FINISH_OPERATION = 3;

    // 扫描
    public static final String BARCODE_SCAN_FUNCTION = "barcode_scan_function";

    // 搜索药物
    public static final String SEARCH_APPROVAL_FROM_DRUG_LIST = "search_approval_from_drug_list";

    // 入库
    public static final String WAREHOUSING_DRUG_DETAIL = "warehousing_drug_detail";
    public static final String WAREHOUSING_ADD_PROVIDER = "warehousing_add_provider";
    public static final String WAREHOUSING_INVENTORY = "warehousing_inventory";
    public static final String WAREHOUSING_IS_LOCAL_EDIT = "warehousing_is_local_edit";
    public static final String WAREHOUSING_DRUG_OPERATE_DATA = "warehousing_drug_operate_data";
    public static final String FROM_WAREHOUSING_ACTIVITY = "from_warehousing_activity";

    //添加药物
    public static final String IS_ADD_DRUG = "is_add_drug";
    public static final String ADD_DRUG_NAME = "add_drug_name";
    public static final String EDIT_DRUG_INTANCE = "edit_drug";

    public static final String BARCODE_SCAN_DRUG = "barcode_scan_drug";

    // 售药
    public static final String SALE_DRUG_LIST = "sale_drug_list";

    // 盘点
    public static final String CHECKING_LIST_DRUG = "checking_list_drug";
    public static final String CHECKING_EDIT_DATA_LIST = "checking_edit_data_list";
    public static final String CHECKING_OPERATE_INVENTORY_LIST = "checking_operate_inventory_list";

    // 报损
    public static final String BREAKAGE_DRUG = "breakage_drug";
    public static final String BREAKAGE_OPERATE_INVENTORY_LIST = "breakage_operate_inventory_list";
    public static final String BREAKAGE_DRUG_OPERATE_LIST = "breakage_drug_operate_list";

    // 退货
    public static final String INVENTORY_RETURN_DRUG = "inventory_return_drug";
    public static final String INVENTORY_RETURN_OPERATE_INVENTORY_LIST = "inventory_return_operate_inventory_list";
    public static final String INVENTORY_RETURN_DRUG_OPERATE_LIST = "inventory_return_drug_operate_list";

    // 调价
    public static final String PRICE_ADJUSTMENT_DRUG = "price_adjustment_drug";
    public static final String PRICE_ADJUSTMENT_DRUG_OPERATE_DATA = "price_adjustment_drug_operate_data";

    // 售药记录
    public static final String SALE_BILLING = "SALE_BILLING";
    public static final String SALE_RECORD_LIST = "SALE_RECORD_LIST";

    // 退货车
    public static final String RETURN_CART_DATA_LIST = "return_cart_data_list";
    public static final String IS_RETURN_SALE_DRUG = "is_return_sale_drug";
    public static final String RETURN_SALE_DRUG_AMOUNT = "return_sale_drug_amount";

    // 预警
    public static final String Alert_DRUG_INFO = "Alert_DRUG_INFO";

    // 药物列表
    public static final String DRUG_DETAIL_DRUG_INFO = "drug_detail_drug_info";
    public static final String DRUG_DETAIL_OPERATE_INVENTORY_LIST = "drug_detail_operate_inventory_list";

    // 诊所设置
    public static final String IS_DISPLAY_MODULE = "is_display_module";
    public static final String EMPLOYEE_DETAIL_INFO = "employee_detail_info";
    public static final String EMPLOYEE_PERMISSION = "employee_permission";
    public static final String IS_DEFAULT_SHOW = "is_default_show";
    public static final String IS_PRINT_SHOW = "is_print_show";

    // 激活和续费
    public static final String IS_CREATE_NEW_EMPLOYEE = "is_new_create_employee";
    public static final String IS_ACTIVATION = "is_activation";
    public static final String ACTIVATION_EMPLOYEE = "activation_employee";
    public static final String RENEW_EMPLOYEE_LIST = "renew_employee_list";
    public static final String RENEW_YEARS = "renew_years";

    // 审核
    public static final String AUDIT_IS_DRUG_APPROVE = "audit_is_drug_approve";
    public static final String AUDIT_FUNCTION = "audit_function";
    public static final String AUDIT_LOG_ID_LIST = "audit_log_id_list";
    public static final String AUDIT_DRUG = "audit_drug";
    public static final String AUDIT_DRUG_OPERATE_INFO = "audit_drug_operate_info";
    public static final String AUDIT_DRUG_OPERATE_LIST = "audit_drug_operate_list";
    public static final String AUDIT_INVENTORY = "audit_inventory";
    public static final String AUDIT_OPERATE_INVENTORY_LIST = "audit_operate_inventory_list";
    public static final String AUDIT_LIST_DATA = "audit_list_data";
    public static final String AUDIT_LIST_INDEX = "audit_list_index";
    public static final String IS_AUDIT_EDIT = "is_audit_edit";

    // 我的收入
    public static final String INCOME_CHECK_TYPE = "income_check_type";
    public static final String INCOME_RADIO_CHECK_ID = "income_duration";
    public static final String INCOME_DETAIL_ITEM = "income_detail_item";
    public static final String INCOME_DETAIL_WITHDRAW = "income_detail_withdraw";

    // 视频教程
    public static final String VIDEO_TUTORIAL_TITLE = "video_tutorial_title";
    public static final String VIDEO_TUTORIAL_URL = "video_tutorial_url";

    // 登陆状态
    public static final String LOGIN_STATUS = "loginStatus";
    public static final int LOGIN_IN = 1;
    public static final int LOGIN_OUT = 2;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public static final int UPDATE_NAME = 1;
    public static final int UPDATE_ADDRESS = 2;
    public static final int UPDATE_SPECIALTY_NAME = 3;
    public static final int UPDATE_GRADUATE_SCHOOL = 4;
    public static final int UPDATE_RESUME = 5;
    public static final int UPDATE_BIRTHDAY = 6;
    public static final int UPDATE_SEX = 7;

    public static final String UPDATE_DIALOG_SHOW = "update_dialog_show";

    /**
     * requestCode = 1 跳转到PersonEditInfoActivity
     **/
    public static final int JUMP_TO_PERSON = 20;

    /**
     * requestCode = 2 跳转到PatientDetailInfoActivity
     **/
    public static final int JUMP_TO_PATIENT = 10;

    public static final String LOCATION_CONTURY_ID = "location_contury_id";
    public static final String LOCATION_PROVINCE_ID = "location_province_id";
    public static final String LOCATION_CITY_ID = "location_city_id";
    public static final String LOCATION_DISTRICT_ID = "location_district_id";
    public static final String LOCATION_ADDRESS = "location_address";
    public static final String LOCATION_STREET = "location_street";

    // 界面之间请求启动activity的请求code
    public static final int APPIONTMENT_REQUEST_CODE = 1;// 挂号请求
    public static final int APPIONTMENT_NEXT_REQUEST_CODE = 2;// 挂号请求
    public static final int APPIONTMENT_ASSIGN_REQUEST_CODE = 3;// 重新分配
    public static final int DOCTOR_REQUEST_CODE = 4;// 请求医生，在选择医生界面
    public static final int SYMPTOM_REQUEST_CODE = 5;// 请求症状，在症状界面
    public static final int PASSWORD_REQUEST_CODE = 6;// 请求修改密码界面
    public static final int PATIENT_REQUEST_CODE = 7;
    public static final int LOCATION_REQUEST_CODE = 8;
    public static final int EMPLOYEE_GENDER_REQUEST = 9;

    public static final int TO_ANAMENSIS_ACTIVITY = 0x11;

    // 请求对应的结果
    public static final int APPIONTMENT_RESULT_CODE = 1;// 预约成
    public static final int APPIONTMENT_NEXT_RESULT_CODE = 2;// 下一个预约
    public static final int DOCTOR_RESULT_CODE = 3;// 请求医生，在选择医生界面
    public static final int SYMPTOM_RESULT_CODE = 4;// 请求症状，在症状界面
    public static final int PASSWORD_RESULT_CODE = 5;// 请求修改密码界面
    public static final int PATIENT_RESULT_CODE = 6;
    public static final int PATIENT_ADDRESS_RESULT_CODE = 7;
    public static final int LOCATION_RESULT_CODE = 8;
    public static final int SCHEDULE_REQUESTCODE = 9;

    public static final String PHOTO_ID = "photo_id";
    public static final String INCOME_TYPE = "income_type";

    public static final String SCHEDULE_DATE = "schedule_date";

    //登录相关常量
    public static final String LOGIN_EMPLOYEE = "login_employee";
    public static final String DEVICE_ID = "device_id";

    //导诊屏IP
    public static final String SCREEEN_IP = "screen_ip";

    public static final int INCOME_DAY = 1;
    public static final int INCOME_WEEK = 2;
    public static final int INCOME_MONTH = 3;
    public static final int INCOME_YEAR = 4;

}
