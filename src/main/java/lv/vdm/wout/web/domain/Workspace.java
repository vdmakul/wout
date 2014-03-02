package lv.vdm.wout.web.domain;

import lv.vdm.wout.domain.person.User;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Workspace {

    private User user = new User() {{
        login = "test user";
    }};

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
