package id.co.myapp.temporalio.client.one.saga.workflow;

import java.time.Duration;

import id.co.myapp.temporalio.client.one.saga.activity.ClientOneSagaActivity;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

public class ClientOneSagaWorkflowImpl implements ClientOneSagaWorkflow {

	private ActivityOptions options = ActivityOptions.newBuilder().setScheduleToCloseTimeout(Duration.ofSeconds(2))
			.build();

	private final ClientOneSagaActivity clientOneSagaActivity = Workflow.newActivityStub(ClientOneSagaActivity.class,
			options);

	@Override
	public String triggerClientOneWorkflow(String identifier) {
		System.out.println("Entering triggerClientOneWorkflow for " + identifier);

		clientOneSagaActivity.triggerClientOneActivity_seq1(identifier);

		return "Workflow done for " + identifier;
	}

}
