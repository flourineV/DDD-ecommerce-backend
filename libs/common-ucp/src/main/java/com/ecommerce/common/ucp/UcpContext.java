package com.ecommerce.common.ucp;

import lombok.Data;

@Data
public class UcpContext {
    private String userId;
    private String username;
    private String role;
    private String tenantId;
    
    private static final ThreadLocal<UcpContext> contextHolder = new ThreadLocal<>();
    
    public static void setContext(UcpContext context) {
        contextHolder.set(context);
    }
    
    public static UcpContext getContext() {
        return contextHolder.get();
    }
    
    public static void clear() {
        contextHolder.remove();
    }
}
