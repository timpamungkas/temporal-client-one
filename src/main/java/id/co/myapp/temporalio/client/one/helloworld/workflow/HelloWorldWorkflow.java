package id.co.myapp.temporalio.client.one.helloworld.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface HelloWorldWorkflow {

	@WorkflowMethod
	String triggerWorkflow(String name);

}