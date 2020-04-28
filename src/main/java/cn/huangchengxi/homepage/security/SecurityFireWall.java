package cn.huangchengxi.homepage.security;

import org.springframework.security.web.firewall.StrictHttpFirewall;

public class SecurityFireWall extends StrictHttpFirewall {
    public void setThisAllowUrlEncodeDoubleSlash(boolean allow){
        this.setAllowUrlEncodedDoubleSlash(allow);
        this.setAllowUrlEncodedSlash(allow);
    }
}
