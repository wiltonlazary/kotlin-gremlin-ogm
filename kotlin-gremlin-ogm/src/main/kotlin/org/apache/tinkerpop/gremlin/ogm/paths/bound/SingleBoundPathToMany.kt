package org.apache.tinkerpop.gremlin.ogm.paths.bound

import org.apache.tinkerpop.gremlin.ogm.elements.Vertex
import org.apache.tinkerpop.gremlin.ogm.paths.Path

/**
 * A [SingleBoundPath] that results to 0 or more 'TO' objects for each 'FROM' object
 * the path is traversed with.
 */
class SingleBoundPathToMany<FROM : Vertex, TO>(
        override val from: FROM,
        override val path: Path.ToMany<FROM, TO>
) : SingleBoundPath.ToMany<FROM, TO>
