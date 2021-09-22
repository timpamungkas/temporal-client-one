package id.co.myapp.temporalio.client.one.saga.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface ClientOneSagaWorkflow {

	@WorkflowMethod
	String triggerClientOneWorkflow(String name);

}