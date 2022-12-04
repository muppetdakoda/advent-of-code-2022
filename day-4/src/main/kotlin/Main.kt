fun main() {
    val lines = readFileAsLines("input.txt")

    val pairs = lines.map { line ->
        Pair(
            first = Assignment(line.split(",")[0]),
            second = Assignment(line.split(",")[1]),
        )
    }

    doOverlaps(pairs)
}

fun doOverlaps(pairs: List<Pair<Assignment, Assignment>>) {
    var numOfOverlaps = 0
    pairs.map {
        it.first.sections.toSet() to it.second.sections.toSet()
    }.forEach { (aOne, aTwo) ->
        if (aOne.intersect(aTwo).isNotEmpty()) {
            numOfOverlaps += 1
        }
    }

    println("There are $numOfOverlaps overlapping assignments")
}

fun doRedundantAssignments(pairs: List<Pair<Assignment, Assignment>>) {
    var numOfRedundantAssignments = 0
    pairs.forEach { (aOne, aTwo) ->
        if (
            aOne.sections.containsAll(aTwo.sections)
            || aTwo.sections.containsAll(aOne.sections)
        ) {
            numOfRedundantAssignments += 1
        }
    }

    println("There are $numOfRedundantAssignments redundant assignments")
}