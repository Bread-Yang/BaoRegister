package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.Table;
import net.tsz.afinal.annotation.sqlite.Transient;

import java.util.Date;

@Table(name = "Employee")
public class Employee implements Parcelable {
	@Transient
	public static final int DOCTOR = 1;
	@Transient
	public static final int NURSE = 2;
	@Transient
	public static final int Patient = 3;

	// 排班员
	@Transient
	public static final int Scheduling = 4;

	// 导诊屏
	@Transient
	public static final int SCREEN = 8;

	// 收银员
	@Transient
	public static final int CASHIER = 16;

	// 药方管理员
	@Transient
	public static final int PHARMACY = 32;

	// 患者管理员
	@Transient
	public static final int PATIENT_MANAGER = 64;

	// 诊所管理员
	@Transient
	public static final int CLINIC_MANAGER = 128;

	// 审核员
	@Transient
	public static final int AUDIT_MANAGER = 256;

	@Id
	public int id;
	public int EmployeeID;
	public int ClinicID;
	public String EmployeeCode;
	public String EmployeeName;
	public String LoginID;
	public String LoginPwd;

	public int EmployeeRole;

	public int PhotoID;

	public int PhotoSID;

	public int Gender;

	public Date DOB;

	public String IDCard;

	public String QRCode;

	public String EmployeeTitle;

	public String EMRType;

	public String GraduateSchool;

	public String SpecialtyCode;

	public String SpecialtyName;
	
	/**
	 * 微信用户所在公众号唯一ID
	 */
	public String UnionID;
	
	/**
	 * 微信用户的唯一ID
	 */
	public String OpenID;

	public boolean HasCertification;

	public String ZiGeNo;

	public String ZhiYeNo;

	public String ZhiYeType;

	public String ZhiYeRange;

	public Date ZhiYeIssuedTime;

	public int CountryID;

	public int ProvinceID;

	public int CityID;

	public int DistrictID;

	public String Street;

	public String Address;

	public String WorkPhone;

	public String WorkEmail;

	public String WorkWX;

	public String Resume;

	public float PrintPosTop;

	public float PrintPosLeft;

	public boolean NeedCosign;

	public boolean NeedResetPwd;

	public boolean NeedUpdateData;

	public int LoginFailNum;

	public Date UpdatedPwdTime;

	public Date LoginTime;

	public Date ExpiredTime;

	public boolean SystemLock;

	public int SystemTimeout;

	public int Status;
	
	public boolean NeedBindWechat;
	
	public String WeChatName;

	public int UpdatedBy;

	public Date UpdatedTime;

	public int CreatedBy;

	public Date CreatedTime;

	public int DeviceID;

	public String ServiceToken;

	public String URL;

	public String ClinicName;

	public String SupportName;

	public String SupportPhone;

	public boolean IsInitialAccount;

    public Employee() {

    }

	protected Employee(Parcel in) {
		id = in.readInt();
		EmployeeID = in.readInt();
		ClinicID = in.readInt();
		EmployeeCode = in.readString();
		EmployeeName = in.readString();
		LoginID = in.readString();
		LoginPwd = in.readString();
		EmployeeRole = in.readInt();
		PhotoID = in.readInt();
		PhotoSID = in.readInt();
		Gender = in.readInt();
		{
			long tempDOBTime = in.readLong();
			this.DOB = tempDOBTime == -1 ? null : new Date(tempDOBTime);
		}
		IDCard = in.readString();
		QRCode = in.readString();
		EmployeeTitle = in.readString();
		EMRType = in.readString();
		GraduateSchool = in.readString();
		SpecialtyCode = in.readString();
		SpecialtyName = in.readString();
		UnionID = in.readString();
		OpenID = in.readString();
		HasCertification = in.readByte() != 0;
		ZiGeNo = in.readString();
		ZhiYeNo = in.readString();
		ZhiYeType = in.readString();
		ZhiYeRange = in.readString();
		{
			long tempTime = in.readLong();
			this.ZhiYeIssuedTime = tempTime == -1 ? null : new Date(tempTime);
		}
		CountryID = in.readInt();
		ProvinceID = in.readInt();
		CityID = in.readInt();
		DistrictID = in.readInt();
		Street = in.readString();
		Address = in.readString();
		WorkPhone = in.readString();
		WorkEmail = in.readString();
		WorkWX = in.readString();
		Resume = in.readString();
		PrintPosTop = in.readFloat();
		PrintPosLeft = in.readFloat();
		NeedCosign = in.readByte() != 0;
		NeedResetPwd = in.readByte() != 0;
		NeedUpdateData = in.readByte() != 0;
		LoginFailNum = in.readInt();
		{
			long tempTime = in.readLong();
			this.UpdatedPwdTime = tempTime == -1 ? null : new Date(tempTime);
		}
		{
			long tempTime = in.readLong();
			this.LoginTime = tempTime == -1 ? null : new Date(tempTime);
		}
		{
			long tempTime = in.readLong();
			this.ExpiredTime = tempTime == -1 ? null : new Date(tempTime);
		}
		SystemLock = in.readByte() != 0;
		SystemTimeout = in.readInt();
		Status = in.readInt();
		NeedBindWechat = in.readByte() != 0;
		WeChatName = in.readString();
		UpdatedBy = in.readInt();
		{
			long tempTime = in.readLong();
			this.UpdatedTime = tempTime == -1 ? null : new Date(tempTime);
		}
		CreatedBy = in.readInt();
		{
			long tempTime = in.readLong();
			this.CreatedTime = tempTime == -1 ? null : new Date(tempTime);
		}
		DeviceID = in.readInt();
		ServiceToken = in.readString();
		URL = in.readString();
		ClinicName = in.readString();
		SupportName = in.readString();
		SupportPhone = in.readString();
		IsInitialAccount = in.readInt() == 1 ? true : false;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeInt(EmployeeID);
		dest.writeInt(ClinicID);
		dest.writeString(EmployeeCode);
		dest.writeString(EmployeeName);
		dest.writeString(LoginID);
		dest.writeString(LoginPwd);
		dest.writeInt(EmployeeRole);
		dest.writeInt(PhotoID);
		dest.writeInt(PhotoSID);
		dest.writeInt(Gender);
		{
			if (DOB == null) {
				dest.writeLong(-1);
			} else {
				dest.writeLong(DOB.getTime());
			}
		}
		dest.writeString(IDCard);
		dest.writeString(QRCode);
		dest.writeString(EmployeeTitle);
		dest.writeString(EMRType);
		dest.writeString(GraduateSchool);
		dest.writeString(SpecialtyCode);
		dest.writeString(SpecialtyName);
		dest.writeString(UnionID);
		dest.writeString(OpenID);
		dest.writeByte((byte) (HasCertification ? 1 : 0));
		dest.writeString(ZiGeNo);
		dest.writeString(ZhiYeNo);
		dest.writeString(ZhiYeType);
		dest.writeString(ZhiYeRange);
		{
			if (ZhiYeIssuedTime == null) {
				dest.writeLong(-1);
			} else {
				dest.writeLong(ZhiYeIssuedTime.getTime());
			}
		}
		dest.writeInt(CountryID);
		dest.writeInt(ProvinceID);
		dest.writeInt(CityID);
		dest.writeInt(DistrictID);
		dest.writeString(Street);
		dest.writeString(Address);
		dest.writeString(WorkPhone);
		dest.writeString(WorkEmail);
		dest.writeString(WorkWX);
		dest.writeString(Resume);
		dest.writeFloat(PrintPosTop);
		dest.writeFloat(PrintPosLeft);
		dest.writeByte((byte) (NeedCosign ? 1 : 0));
		dest.writeByte((byte) (NeedResetPwd ? 1 : 0));
		dest.writeByte((byte) (NeedUpdateData ? 1 : 0));
		dest.writeInt(LoginFailNum);
		{
			if (UpdatedPwdTime == null) {
				dest.writeLong(-1);
			} else {
				dest.writeLong(UpdatedPwdTime.getTime());
			}
		}
		{
			if (LoginTime == null) {
				dest.writeLong(-1);
			} else {
				dest.writeLong(LoginTime.getTime());
			}
		}
		{
			if (ExpiredTime == null) {
				dest.writeLong(-1);
			} else {
				dest.writeLong(ExpiredTime.getTime());
			}
		}
		dest.writeByte((byte) (SystemLock ? 1 : 0));
		dest.writeInt(SystemTimeout);
		dest.writeInt(Status);
		dest.writeByte((byte) (NeedBindWechat ? 1 : 0));
		dest.writeString(WeChatName);
		dest.writeInt(UpdatedBy);
		{
			if (UpdatedTime == null) {
				dest.writeLong(-1);
			} else {
				dest.writeLong(UpdatedTime.getTime());
			}
		}
		dest.writeInt(CreatedBy);
		{
			if (CreatedTime == null) {
				dest.writeLong(-1);
			} else {
				dest.writeLong(CreatedTime.getTime());
			}
		}
		dest.writeInt(DeviceID);
		dest.writeString(ServiceToken);
		dest.writeString(URL);
		dest.writeString(ClinicName);
		dest.writeString(SupportName);
		dest.writeString(SupportPhone);
		dest.writeInt(IsInitialAccount ? 1 : 0);
	}

	public static final Creator<Employee> CREATOR = new Creator<Employee>() {
		@Override
		public Employee createFromParcel(Parcel in) {
			return new Employee(in);
		}

		@Override
		public Employee[] newArray(int size) {
			return new Employee[size];
		}
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public int getClinicID() {
		return ClinicID;
	}

	public void setClinicID(int clinicID) {
		ClinicID = clinicID;
	}

	public String getEmployeeCode() {
		return EmployeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		EmployeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getLoginID() {
		return LoginID;
	}

	public void setLoginID(String loginID) {
		LoginID = loginID;
	}

	public String getLoginPwd() {
		return LoginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}

	public int getEmployeeRole() {
		return EmployeeRole;
	}

	public void setEmployeeRole(int employeeRole) {
		EmployeeRole = employeeRole;
	}

	public int getPhotoID() {
		return PhotoID;
	}

	public void setPhotoID(int photoID) {
		PhotoID = photoID;
	}

	public int getPhotoSID() {
		return PhotoSID;
	}

	public void setPhotoSID(int photoSID) {
		PhotoSID = photoSID;
	}

	public int getGender() {
		return Gender;
	}

	public void setGender(int gender) {
		Gender = gender;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getQRCode() {
		return QRCode;
	}

	public void setQRCode(String qRCode) {
		QRCode = qRCode;
	}

	public String getEmployeeTitle() {
		return EmployeeTitle;
	}

	public void setEmployeeTitle(String employeeTitle) {
		EmployeeTitle = employeeTitle;
	}

	public String getEMRType() {
		return EMRType;
	}

	public void setEMRType(String eMRType) {
		EMRType = eMRType;
	}

	public String getGraduateSchool() {
		return GraduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		GraduateSchool = graduateSchool;
	}

	public String getSpecialtyCode() {
		return SpecialtyCode;
	}

	public void setSpecialtyCode(String specialtyCode) {
		SpecialtyCode = specialtyCode;
	}

	public String getSpecialtyName() {
		return SpecialtyName;
	}

	public void setSpecialtyName(String specialtyName) {
		SpecialtyName = specialtyName;
	}
	
	public String getUnionID() {
		return UnionID;
	}

	public void setUnionID(String unionID) {
		UnionID = unionID;
	}

	public String getOpenID() {
		return OpenID;
	}

	public void setOpenID(String openID) {
		OpenID = openID;
	}

	public boolean isHasCertification() {
		return HasCertification;
	}

	public void setHasCertification(boolean hasCertification) {
		HasCertification = hasCertification;
	}

	public String getZiGeNo() {
		return ZiGeNo;
	}

	public void setZiGeNo(String ziGeNo) {
		ZiGeNo = ziGeNo;
	}

	public String getZhiYeNo() {
		return ZhiYeNo;
	}

	public void setZhiYeNo(String zhiYeNo) {
		ZhiYeNo = zhiYeNo;
	}

	public String getZhiYeType() {
		return ZhiYeType;
	}

	public void setZhiYeType(String zhiYeType) {
		ZhiYeType = zhiYeType;
	}

	public String getZhiYeRange() {
		return ZhiYeRange;
	}

	public void setZhiYeRange(String zhiYeRange) {
		ZhiYeRange = zhiYeRange;
	}

	public Date getZhiYeIssuedTime() {
		return ZhiYeIssuedTime;
	}

	public void setZhiYeIssuedTime(Date zhiYeIssuedTime) {
		ZhiYeIssuedTime = zhiYeIssuedTime;
	}

	public int getCountryID() {
		return CountryID;
	}

	public void setCountryID(int countryID) {
		CountryID = countryID;
	}

	public int getProvinceID() {
		return ProvinceID;
	}

	public void setProvinceID(int provinceID) {
		ProvinceID = provinceID;
	}

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
	}

	public int getDistrictID() {
		return DistrictID;
	}

	public void setDistrictID(int districtID) {
		DistrictID = districtID;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getWorkPhone() {
		return WorkPhone;
	}

	public void setWorkPhone(String workPhone) {
		WorkPhone = workPhone;
	}

	public String getWorkEmail() {
		return WorkEmail;
	}

	public void setWorkEmail(String workEmail) {
		WorkEmail = workEmail;
	}

	public String getWorkWX() {
		return WorkWX;
	}

	public void setWorkWX(String workWX) {
		WorkWX = workWX;
	}

	public String getResume() {
		return Resume;
	}

	public void setResume(String resume) {
		Resume = resume;
	}

	public float getPrintPosTop() {
		return PrintPosTop;
	}

	public void setPrintPosTop(float printPosTop) {
		PrintPosTop = printPosTop;
	}

	public float getPrintPosLeft() {
		return PrintPosLeft;
	}

	public void setPrintPosLeft(float printPosLeft) {
		PrintPosLeft = printPosLeft;
	}

	public boolean isNeedCosign() {
		return NeedCosign;
	}

	public void setNeedCosign(boolean needCosign) {
		NeedCosign = needCosign;
	}

	public boolean isNeedResetPwd() {
		return NeedResetPwd;
	}

	public void setNeedResetPwd(boolean needResetPwd) {
		NeedResetPwd = needResetPwd;
	}

	public boolean isNeedUpdateData() {
		return NeedUpdateData;
	}

	public void setNeedUpdateData(boolean needUpdateData) {
		NeedUpdateData = needUpdateData;
	}

	public int getLoginFailNum() {
		return LoginFailNum;
	}

	public void setLoginFailNum(int loginFailNum) {
		LoginFailNum = loginFailNum;
	}

	public Date getUpdatedPwdTime() {
		return UpdatedPwdTime;
	}

	public void setUpdatedPwdTime(Date updatedPwdTime) {
		UpdatedPwdTime = updatedPwdTime;
	}

	public Date getLoginTime() {
		return LoginTime;
	}

	public void setLoginTime(Date loginTime) {
		LoginTime = loginTime;
	}

	public Date getExpiredTime() {
		return ExpiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		ExpiredTime = expiredTime;
	}

	public boolean isSystemLock() {
		return SystemLock;
	}

	public void setSystemLock(boolean systemLock) {
		SystemLock = systemLock;
	}

	public int getSystemTimeout() {
		return SystemTimeout;
	}

	public void setSystemTimeout(int systemTimeout) {
		SystemTimeout = systemTimeout;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public boolean isNeedBindWechat() {
		return NeedBindWechat;
	}

	public void setNeedBindWechat(boolean needBindWechat) {
		NeedBindWechat = needBindWechat;
	}

	public String getWeChatName() {
		return WeChatName;
	}

	public void setWeChatName(String weChatName) {
		WeChatName = weChatName;
	}

	public int getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		UpdatedBy = updatedBy;
	}

	public Date getUpdatedTime() {
		return UpdatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		UpdatedTime = updatedTime;
	}

	public int getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(int createdBy) {
		CreatedBy = createdBy;
	}

	public Date getCreatedTime() {
		return CreatedTime;
	}

	public void setCreatedTime(Date createdTime) {
		CreatedTime = createdTime;
	}

	public int getDeviceID() {
		return DeviceID;
	}

	public void setDeviceID(int deviceID) {
		DeviceID = deviceID;
	}

	public String getServiceToken() {
		return ServiceToken;
	}

	public void setServiceToken(String serviceToken) {
		ServiceToken = serviceToken;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getClinicName() {
		return ClinicName;
	}

	public void setClinicName(String clinicName) {
		ClinicName = clinicName;
	}

	public String getSupportName() {
		return SupportName;
	}

	public void setSupportName(String supportName) {
		SupportName = supportName;
	}

	public String getSupportPhone() {
		return SupportPhone;
	}

	public void setSupportPhone(String supportPhone) {
		SupportPhone = supportPhone;
	}

	public boolean isInitialAccount() {
		return IsInitialAccount;
	}

	public void setIsInitialAccount(boolean isInitialAccount) {
		IsInitialAccount = isInitialAccount;
	}

	public String getGenderStr() {
		if (Gender == 1) {
			return "男";
		} else {
			return "女";
		}
	}

	public String getPhotoUrl() {
//		return "https://file.yideguan.com/View/GetFile.aspx?FileID=" + PhotoSID + "&ClinicID=" + ClinicID;
		 return "image://" + ClinicID + "." + PhotoSID;
	}

	@Override
	public int describeContents() {
		return 0;
	}

}
