/*
 * Copyright 2021 Monotonic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.real_logic.artio.session;

/**
 * Handler interface that is invoked after a cancel on disconnect timeout for an acceptor session.
 *
 * In order for this handler to be invoked:
 * <ul>
 *  <li>Your FIX session dictionary must contain a cancel on disconnect type field associated with a logon
 *  message</li>
 *  <li>A session must specify a CancelOnDisconnectType field in it's logon message that requires
 * a cancel on either logout, disconnect or both</li>
 *  <li>the CODTimeoutWindow also specified in the logon message must have expired without a reconnect</li>
 * </ul>.
 *
 * You can see <a href="https://github.com/real-logic/artio/wiki/Cancel-On-Disconnect-Notification">the wiki</a>
 * for more details around Cancel on disconnect support.
 *
 * Initiator implementations using cancel on disconnect can set the requisite logon fields using a
 * {@link SessionCustomisationStrategy}.
 *
 * The FIXP equivalent to this interface is {@link uk.co.real_logic.artio.fixp.FixPCancelOnDisconnectTimeoutHandler}.
 */
public interface CancelOnDisconnectTimeoutHandler
{
    /**
     * Method invoked when a cancel on disconnect is triggered. This handler is invoked on the Framer thread.
     *
     * @param sessionId the surrogate session id of the cod session.
     * @param fixSessionKey the full session id of the cod session.
     */
    void onCancelOnDisconnectTimeout(long sessionId, CompositeKey fixSessionKey);
}
