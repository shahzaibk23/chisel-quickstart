package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class exercise1Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 1 Test" in {
        test(new Counter3(8)){ c =>
            c.clock.step(20)
            c.io.result.expect(0.B)
        }
    }
}