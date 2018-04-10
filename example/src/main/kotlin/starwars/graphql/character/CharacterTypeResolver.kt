package starwars.graphql.character

import org.apache.tinkerpop.gremlin.ogm.GraphMapper
import org.apache.tinkerpop.gremlin.ogm.relationships.bound.out
import starwars.models.Character
import starwars.models.Character.Companion.friends
import starwars.models.Episode
import starwars.models.Name
import starwars.traversals.character.toSecondDegreeFriends


interface CharacterTypeResolver {

    val graph: GraphMapper

    fun getId(character: Character): Long = character.id ?: -1
    fun getName(character: Character): Name = character.name
    fun getAppearsIn(character: Character): Set<Episode> = character.appearsIn
    fun getFriends(character: Character): List<Character> = graph.traverse(character out friends)
    fun getSecondDegreeFriends(character: Character, limit: Int?): List<Character> {
        val range = if (limit == null) null else 0 until limit.toLong()
        return graph.traverse(character.toSecondDegreeFriends(range))
    }
}