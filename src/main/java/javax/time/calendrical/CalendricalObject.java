/*
 * Copyright (c) 2012, Stephen Colebourne & Michael Nascimento Santos
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package javax.time.calendrical;

import javax.time.CalendricalException;
import javax.time.LocalDate;
import javax.time.LocalDateTime;

/**
 * An object that represents some form of calendrical information.
 * 
 * <h4>Implementation notes</h4>
 * This interface places no restrictions on implementations and makes no guarantees
 * about their thread-safety.
 */
public interface CalendricalObject extends CalendricalAdjuster {

    /**
     * Extracts an instance of the specified type.
     * <p>
     * An implementation must return the following types if it contains sufficient information:
     * <ul>
     * <li>LocalDate
     * <li>LocalTime
     * <li>LocalDateTime
     * <li>OffsetDate
     * <li>OffsetTime
     * <li>OffsetDateTime
     * <li>ZoneOffset
     * <li>ZoneId
     * <li>Instant
     * <li>DateTimeBuilder
     * <li>this object if the specified type is passed in
     * </ul>
     * Other objects may be returned if appropriate.
     * 
     * @param <T> the type to extract
     * @param type  the type to extract, null returns null
     * @return the extracted object, null if unable to extract
     */
    <T> T extract(Class<T> type);

    /**
     * Returns a copy of this calendrical with the specified calendrical set.
     * <p>
     * This allows the manipulation of a calendrical in a general way.
     * For example, if this calendrical is a {@link LocalDateTime} and the specified calendrical
     * is a {@link LocalDate}, then the implementation will return a new {@code LocalDateTime}
     * with the date changed.
     * <p>
     * An implementation must handle the following types if possible:
     * <ul>
     * <li>DateAdjuster
     * <li>TimeAdjuster
     * <li>LocalDate
     * <li>LocalTime
     * <li>LocalDateTime
     * <li>OffsetDate
     * <li>OffsetTime
     * <li>OffsetDateTime
     * <li>ZoneOffset
     * <li>ZoneId
     * <li>Instant
     * <li>this object if the specified type is passed in
     * </ul>
     * 
     * @param calendrical  the calendrical to set into this calendrical, null returns null
     * @return a copy of this calendrical with the specified calendrical set, not null
     * @throws CalendricalException if unable to set the calendrical into this calendrical
     */
    CalendricalObject with(CalendricalAdjuster calendrical);

}