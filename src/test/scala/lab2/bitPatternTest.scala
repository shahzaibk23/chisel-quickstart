package lab2

import org.scalatest._
import chiseltest._
import chisel3._

class bitPatternTest extends FreeSpec with ChiselScalatestTester {
    "Bit Patteren Test" in {
        test(new bitPatterns){ c =>
            c.io.out.expect(1.B)
        }
    }
}