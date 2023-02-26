class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        var combinations: List<List<List<Int>>> = mutableListOf()
        combinations += COMBINATION_FOR_ZERO

        findCombinationsTillTarget(
                target = target,
                findCombinations = {

                }
        )

        return combinations[target]
    }

    private fun findCombinationsTillTarget(target: Int, findCombinations: () -> Unit) {
        (1 .. target).forEach { i ->
            findCombinations()
        }
    }

    private fun isCurrentTarget(
            previousPosition: Int,
            currentCandidate: Int,
            currentTarget: Int
    ): Boolean = previousPosition + currentCandidate == currentTarget

    companion object {
        private val COMBINATION_FOR_ZERO = listOf(listOf(listOf(0)))
    }
}