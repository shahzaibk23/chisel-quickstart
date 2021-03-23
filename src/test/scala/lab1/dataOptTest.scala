package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class dataOptTest extends FreeSpec with ChiselScalatestTester {
    "Data Opt Test" in {
        test(new AdderWithOffset){ c =>
            c.io.x.poke(2.S)
            c.io.y.poke(3.U)
            c.clock.step(2)
            c.io.z.expect(65532.U)
        }
    }
}