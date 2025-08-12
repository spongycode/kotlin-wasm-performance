import kotlin.math.sqrt

@OptIn(ExperimentalJsExport::class)
@JsExport
fun addNumbers(a: Int, b: Int): Int {
	return a + b
}


@JsExport
fun sumFirstNPrimes(n: Int): Long {
	var count = 0
	var num = 2
	var sum = 0L
	while (count < n) {
		if (isPrime(num)) {
			sum += num
			count++
		}
		num++
	}
	return sum
}

fun isPrime(x: Int): Boolean {
	if (x < 2) return false
	for (i in 2..sqrt(x.toDouble()).toInt()) {
		if (x % i == 0) return false
	}
	return true
}

