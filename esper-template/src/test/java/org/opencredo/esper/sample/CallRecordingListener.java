/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencredo.esper.sample;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * A listener used for testing and sample purposes.
 * 
 * This class meets both the listener and subscriber contracts as offered by
 * Esper.
 * 
 * For a comparison of these contracts, see
 * http://esper.codehaus.org/esper-3.3.0/doc/reference/en/html/api.html#api-receive-results
 * 
 * @author Russ Miles (russell.miles@opencredo.com)
 * 
 */
public class CallRecordingListener implements UpdateListener {

	protected int numberOfTimesInvoked = 0;

	public int getNumberOfTimesInvoked() {
		return numberOfTimesInvoked;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.espertech.esper.client.UpdateListener#update(com.espertech.esper.
	 * client.EventBean[], com.espertech.esper.client.EventBean[])
	 */
	public void update(EventBean[] eventBeans, EventBean[] eventBeans1) {
		this.numberOfTimesInvoked++;
	}
	
	public void update(EventBean[] eventBeans) {
		this.numberOfTimesInvoked++;
	}

	/**
	 * Method used when this class is being used as a subscriber as opposed to a
	 * listener.
	 * 
	 * @param event
	 *            The event detected
	 */
	public void update(SampleEvent event) {
		this.numberOfTimesInvoked++;
	}
}
