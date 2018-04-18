package org.apache.tinkerpop.gremlin.ogm.paths.bound

import org.apache.tinkerpop.gremlin.ogm.paths.relationships.Relationship

/**
 * A [BoundRelationship] that results in 0 or more objects for each [from] object that
 * the traversed path starts with.
 */
class BoundRelationshipToMany<FROM : Any, TO : Any>(
        override val froms: Iterable<FROM>,
        override val path: Relationship.ToMany<FROM, TO>
) : BoundRelationship.ToMany<FROM, TO>