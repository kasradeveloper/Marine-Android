package com.kasra.atency.utility.enums;


public class MyEnums {

    public enum SectionMode {

        NONE {
            @Override
            public String toString() {
                return "0";
            }
        },
        CREATE {
            @Override
            public String toString() {
                return "1";
            }
        },
        MANAGE {
            @Override
            public String toString() {
                return "2";
            }
        },
        DELETE {
            @Override
            public String toString() {
                return "3";
            }
        },
        SHOW {
            @Override
            public String toString() {
                return "4";
            }
        },
        CREATE_ATTENDANCE {
            @Override
            public String toString() {
                return "5";
            }
        }, CREATE_OVER_TIME {
            @Override
            public String toString() {
                return "6";
            }
        }

    }

    public enum CodeIds {

        PENDING {
            @Override
            public String toString() {
                return "7001";
            }
        }, APPROVED {
            @Override
            public String toString() {
                return "7002";
            }
        }, DELETED {
            @Override
            public String toString() {
                return "7003";
            }
        }

    }

    public enum Permissions {

        APPROVE_REQUEST {
            @Override
            public String toString() {
                return "1047";
            }
        }, DENY_REQUEST {
            @Override
            public String toString() {
                return "1048";
            }
        }, SUBORDINATES_REQUEST {
            @Override
            public String toString() {
                return "1069";
            }
        }, MANAGE_REQUEST {
            @Override
            public String toString() {
                return "1070";
            }
        }, SHOW_portfolio {
            @Override
            public String toString() {
                return "1057";
            }
        }, Edit_PLACE {
            @Override
            public String toString() {
                return "21";
            }
        }, DELETE_PLACE {
            @Override
            public String toString() {
                return "22";
            }
        }, ADD_PLACE {
            @Override
            public String toString() {
                return "19";
            }
        }, MESSAGE {
            @Override
            public String toString() {
                return "2133";
            }
        }, OUTDOOR_MODULE {
            @Override
            public String toString() {
                return "2135";
            }
        }, TICKET_MODULE {
            @Override
            public String toString() {
                return "3205";
            }
        }

    }

    public enum RequestClass {

        DAILY {
            @Override
            public String toString() {
                return "1";
            }
        }, TIMELY {
            @Override
            public String toString() {
                return "2";
            }
        }, ATTENDANCE {
            @Override
            public String toString() {
                return "3";
            }
        }, REJECT_REQUEST {
            @Override
            public String toString() {
                return "4";
            }
        }
    }

    public enum RequestCode {

        DAILY_LEAVE {
            @Override
            public String toString() {
                return "4001";
            }
        }, TIMLY_LEAVE {
            @Override
            public String toString() {
                return "4002";
            }
        }, DAILY_OUTDOOR_DUTY {
            @Override
            public String toString() {
                return "4003";
            }
        }, TIMLY_OUTDOOR_DUTY {
            @Override
            public String toString() {
                return "4004";
            }
        }, ATTENDANCE {
            @Override
            public String toString() {
                return "4005";
            }
        }, OVER_TIME {
            @Override
            public String toString() {
                return "3004";
            }
        }, OVER_TIME_REQUEST {
            @Override
            public String toString() {
                return "4006";
            }
        }
    }

    public enum WorkPeriodType {

        JALALI {
            @Override
            public String toString() {
                return "8001";
            }
        }, GREGORIAN {
            @Override
            public String toString() {
                return "8002";
            }
        }

    }

    public enum getTime {

        SPEECHTEXTDATE {
            @Override
            public String toString() {
                return "EEEE dd MMMMM,yyyy";
            }
        },
        BYTIMEZONE {
            @Override
            public String toString() {
                return "yyyy-MM-dd'T'HH:mm:ss.SSS ZZZZZ";
            }
        }, WITHOUTIMEZONE {
            @Override
            public String toString() {
                return "yyyy-MM-dd'T'HH:mm:ss.SSS";
            }
        }, WITHOUTHOUR {
            @Override
            public String toString() {
                return "yyyy-MM-dd";
            }
        }
    }

    public enum AttendanceType {

        Enter {
            @Override
            public String toString() {
                return "1001";
            }
        }, Exit {
            @Override
            public String toString() {
                return "1002";
            }
        }, EnterOutdoor {
            @Override
            public String toString() {
                return "1004";
            }
        }, ExitOutdoor {
            @Override
            public String toString() {
                return "1005";
            }
        }

    }

    public enum AttTypeValue {

        WORKPLACE {
            @Override
            public String toString() {
                return "31";
            }
        }, OUT_DOOR_DUTY_PlACE {
            @Override
            public String toString() {
                return "32";
            }
        }

    }

    public enum PairedAttendanceType {

        All {
            @Override
            public String toString() {
                return "51";
            }
        }, Attendance {
            @Override
            public String toString() {
                return "52";
            }
        }, Duty {
            @Override
            public String toString() {
                return "53";
            }
        }, ManualAttendance {
            @Override
            public String toString() {
                return "54";
            }
        }

    }

    public enum WorkplacesTypes {

        ALL {
            @Override
            public String toString() {
                return "33";
            }
        }, DUTY {
            @Override
            public String toString() {
                return "32";
            }
        }, ATTENDANCE {
            @Override
            public String toString() {
                return "31";
            }
        }

    }

    public enum Status {

        SEEN {
            @Override
            public String toString() {
                return "704";
            }
        }

    }

    public enum UpdateType {

        FORCE {
            @Override
            public String toString() {
                return "93";
            }
        }

    }

    public enum PlatformValue {

        ANDROID {
            @Override
            public String toString() {
                return "83";
            }
        }

    }

    public enum TypeRecorderValue {

        GPS {
            @Override
            public String toString() {
                return "11001";
            }
        }, BLUETOOTH {
            @Override
            public String toString() {
                return "11002";
            }
        }, REMOTE {
            @Override
            public String toString() {
                return "11004";
            }
        }

    }


    public enum TicketStatus {

        PENDING {
            @Override
            public String toString() {
                return "1901";
            }
        }, SUPPORT_REPLY {
            @Override
            public String toString() {
                return "1902";
            }
        }, CLOSED {
            @Override
            public String toString() {
                return "1903";
            }
        }

    }

    public enum TicketPriority {
        MEDIUM {
            @Override
            public String toString() {
                return "1701";
            }
        }, HIGH {
            @Override
            public String toString() {
                return "1702";
            }
        }, VERY_HIGH {
            @Override
            public String toString() {
                return "1703";
            }
        }
    }

    public enum TicketCategory {
        FINANCIAL {
            @Override
            public String toString() {
                return "1801";
            }
        }, HARDWARE {
            @Override
            public String toString() {
                return "1802";
            }
        }, TECHNICAL {
            @Override
            public String toString() {
                return "1803";
            }
        }, OTHER {
            @Override
            public String toString() {
                return "1803";
            }
        }
    }



}
