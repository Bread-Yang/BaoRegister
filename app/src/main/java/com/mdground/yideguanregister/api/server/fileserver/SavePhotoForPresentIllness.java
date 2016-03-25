package com.mdground.yideguanregister.api.server.fileserver;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.google.gson.Gson;
import com.mdground.yideguanregister.api.MdgAppliction;
import com.mdground.yideguanregister.api.base.FileServerRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.Employee;

import org.kobjects.base64.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SavePhotoForPresentIllness extends FileServerRequest {

    public static final String FUNCTION_NAME = "SavePhotoForPresentIllness";

    public SavePhotoForPresentIllness(Context context) {
        super(context);
    }

    @Override
    protected String getFunctionName() {
        return FUNCTION_NAME;
    }

    public void savePhotoForPresentIllness(final File file, final int visitID, final int photoID, final int photoSID, final RequestCallBack callBack) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                setRequestCallBack(callBack);
                if (file == null) {
                    return;
                }

                MdgAppliction appliction = null;
                if (mContext != null && mContext.getApplicationContext() instanceof MdgAppliction) {
                    appliction = (MdgAppliction) mContext.getApplicationContext();
                } else {
                    throw new RuntimeException("please create MdgAppliction !!!");
                }

                if (appliction == null) {
                    return;
                }

                long fileSize = file.length();
                if (fileSize > Integer.MAX_VALUE) {
                    Log.e(TAG, "file too big...");
                    return;
                }

                byte[] buffer = null;
                FileInputStream in = null;
                try {
                    // 一次读多个字节
                    in = new FileInputStream(file);
                    buffer = new byte[(int) fileSize];
                    int offset = 0;
                    int numRead = 0;

                    while (offset < buffer.length && (numRead = in.read(buffer, offset, buffer.length - offset)) >= 0) {
                        offset += numRead;
                    }
                    // 确保所有数据均被读取
                    if (offset != buffer.length) {
                        throw new IOException("Could not completely read file " + file.getName());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (buffer == null || buffer.length == 0) {
                    Log.e(TAG, "read file failed");
                    return;
                }

                String fileName = file.getName();
                String fileExt = fileName.substring(fileName.lastIndexOf(".", fileName.length()));

                String dataStr = Base64.encode(buffer);
                try {
                    dataStr = URLEncoder.encode(dataStr, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                Employee loginEmployee = appliction.getLoginEmployee();

                SaveFileQuery query = new SaveFileQuery();
                query.setCreatedRole(loginEmployee.getEmployeeRole());
                query.setClinicID(loginEmployee.getClinicID());
                query.setCreatedBy(loginEmployee.getEmployeeID());
                query.setVisitID(visitID);
                query.setPhotoID(photoID);
                query.setPhotoSID(photoSID);
                query.setFileExt(fileExt);
                query.setData(dataStr);

                Gson gson = new Gson();
                String queryJson = gson.toJson(query);
                RequestData data = getData();
                data.setQueryData(queryJson);

                pocess(false);
            }
        }).start();
    }

    public void savePhotoForDrug(Bitmap file, int visitID, int photoID, int photoSID, RequestCallBack callBack) {
        if (file == null) {
            return;
        }

        MdgAppliction appliction = null;
        if (mContext != null && mContext.getApplicationContext() instanceof MdgAppliction) {
            appliction = (MdgAppliction) mContext.getApplicationContext();
        } else {
            throw new RuntimeException("please create MdgAppliction !!!");
        }

        if (appliction == null) {
            return;
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        file.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] buffer = baos.toByteArray();

        String dataStr = Base64.encode(buffer);
        try {
            dataStr = URLEncoder.encode(dataStr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Employee loginEmployee = appliction.getLoginEmployee();

        SaveFileQuery query = new SaveFileQuery();
        query.setCreatedRole(loginEmployee.getEmployeeRole());
        query.setClinicID(loginEmployee.getClinicID());
        query.setCreatedBy(loginEmployee.getEmployeeID());
        query.setVisitID(visitID);
        query.setPhotoID(photoID);
        query.setPhotoSID(photoSID);
        query.setFileExt("png");
        query.setData(dataStr);

        Gson gson = new Gson();
        String queryJson = gson.toJson(query);
        RequestData data = getData();
        data.setQueryData(queryJson);

        pocess(false);
    }

    protected class SaveFileQuery {
        private int CreatedRole;
        private int ClinicID;
        private int CreatedBy;
        private int VisitID;
        private int PhotoSID;
        private int PhotoID;
        private String FileExt;
        private String Data;

        public int getCreatedRole() {
            return CreatedRole;
        }

        public void setCreatedRole(int createdRole) {
            CreatedRole = createdRole;
        }

        public int getClinicID() {
            return ClinicID;
        }

        public void setClinicID(int clinicID) {
            ClinicID = clinicID;
        }

        public int getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(int createdBy) {
            CreatedBy = createdBy;
        }

        public int getPhotoSID() {
            return PhotoSID;
        }

        public void setPhotoSID(int photoSID) {
            PhotoSID = photoSID;
        }

        public int getPhotoID() {
            return PhotoID;
        }

        public void setPhotoID(int photoID) {
            PhotoID = photoID;
        }

        public String getFileExt() {
            return FileExt;
        }

        public void setFileExt(String fileExt) {
            FileExt = fileExt;
        }

        public String getData() {
            return Data;
        }

        public void setData(String data) {
            Data = data;
        }

        public int getVisitID() {
            return VisitID;
        }

        public void setVisitID(int visitID) {
            VisitID = visitID;
        }
    }

}
