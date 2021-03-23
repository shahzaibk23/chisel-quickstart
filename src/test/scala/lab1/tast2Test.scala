package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class task2Test extends FreeSpec with ChiselScalatestTester {
    "TASK 2 TEST " in {
        test(new counter_up_down(4)){ c =>
            c.io.data_in.poke(2.U)
            c.io.reload.poke(1.B)
            c.clock.step(20)
            // c.io.out.expect(1.B)
        }
    }
}