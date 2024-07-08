package com.javaweb.base.exception;

public class JavaWebException extends RuntimeException {

        private String errMessage;

        public JavaWebException() {
            super();
        }

        public JavaWebException(String errMessage) {
            super(errMessage);
            this.errMessage = errMessage;
        }

        public String getErrMessage() {
            return errMessage;
        }

        public static void cast(CommonError commonError){
            throw new JavaWebException(commonError.getErrMessage());
        }
        public static void cast(String errMessage){
            throw new JavaWebException(errMessage);
        }

    }
