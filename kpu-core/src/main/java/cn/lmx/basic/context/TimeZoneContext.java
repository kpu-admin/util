//package cn.lmx.basic.context;
//
//import java.time.ZoneId;
//
///**
// * 时区上下文工具类，用于动态设置和获取当前线程的时区
// */
//public class TimeZoneContext {
//    // 线程局部变量存储时区，默认使用系统时区
//    private static final ThreadLocal<ZoneId> CURRENT_ZONE = ThreadLocal.withInitial(ZoneId::systemDefault);
//
//    /**
//     * 设置当前线程的时区
//     * @param zoneId 时区ID（如"Asia/Shanghai"、"America/New_York"）
//     */
//    public static void setZoneId(ZoneId zoneId) {
//        if (zoneId != null) {
//            CURRENT_ZONE.set(zoneId);
//        }
//    }
//
//    /**
//     * 获取当前线程的时区（默认系统时区）
//     */
//    public static ZoneId getZoneId() {
//        return CURRENT_ZONE.get();
//    }
//
//    /**
//     * 清除当前线程的时区（必须调用，防止内存泄漏）
//     */
//    public static void clear() {
//        CURRENT_ZONE.remove();
//    }
//}