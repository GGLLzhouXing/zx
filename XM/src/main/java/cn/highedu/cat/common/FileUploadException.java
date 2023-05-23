package cn.highedu.cat.common;

/**
 * 文件上传异常
 */
public class FileUploadException extends ServiceException {
    public FileUploadException(String message) {
        super(ServiceCode.ERR_FILE_UPLOAD, message);
    }
}
