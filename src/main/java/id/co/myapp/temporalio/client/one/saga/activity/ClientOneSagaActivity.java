package id.co.myapp.temporalio.client.one.saga.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface ClientOneSagaActivity {

	@ActivityMethod
	String triggerClientOneActivity_seq1(String identifier);

}
