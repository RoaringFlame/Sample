package action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class OnlineInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object flag = session.get("flag");
		if (flag == null) {
			System.out.println("----未登录状态");
			return "login";
		} else {
			return invocation.invoke();
		}
	}
}
