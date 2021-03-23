package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class countertTest extends FreeSpec with ChiselScalatestTester {
    "Counter Test" in {
        test(new Counter4(8)){ c =>
            c.clock.step(20)
            c.io.result.expect(0.B)
        }
    }
}