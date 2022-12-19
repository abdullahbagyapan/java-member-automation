package interfaces;

import java.util.List;

import type.CustomerContract;
import type.MemberContract;

public interface IUserAccessLayer<T> {
	
	public boolean login(T contract);
	
	public boolean register(T contract);
	
	public List<MemberContract> showAdmin();
}
