package id.co.myapp.temporalio.client.one.helloworld.workflow;

import java.time.Duration;

import id.co.myapp.temporalio.client.one.helloworld.activity.FormatActivity;
import id.co.myapp.temporalio.client.one.helloworld.activity.ThankYouActivity;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

public class HelloWorldWorkflowImpl implements HelloWorldWorkflow {

	private ActivityOptions options = ActivityOptions.newBuilder().setScheduleToCloseTimeout(Duration.ofSeconds(2))
			.build();

	// ActivityStubs enable calls to Activities as if they are local methods, but
	// actually perform an RPC.
	private final FormatActivity format = Workflow.newActivityStub(FormatActivity.class, options);
	private final ThankYouActivity thankyou = Workflow.newActivityStub(ThankYouActivity.class, options);

	@Override
	public String triggerWorkflow(String name) {
		format.composeGreeting(name);
		thankyou.thankYou(name);

		return "Done for " + name;
	}

}
