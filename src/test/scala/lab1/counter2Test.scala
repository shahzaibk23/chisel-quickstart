package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class counter2Test extends FreeSpec with ChiselScalatestTester {
    "Counter 2 Test" in {
        test(new Counter2(2, 12.U){ c =>
            c.io.in.poke(true.B)
            c.clock.step(20)
            // c.io.result.expect(1.B)
        })
    }
}