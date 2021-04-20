package lab8

import org.scalatest._ 
import chisel3._ 
import chiseltest._ 
import chiseltest.experimental.TestOptionBuilder._ 
import chiseltest.internal.VerilatorBackendAnnotation

class maskedMemoryTest extends FreeSpec with ChiselScalatestTester {
    "Masked Memory Test" in {
        test(new MaskedReadWriteSmem).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
            c.io.write.poke(1.B)
            c.io.enable.poke(1.B)
            c.io.addr.poke(5.U)
            c.io.mask(3).poke(0.B)
            c.io.mask(2).poke(0.B)
            c.io.mask(1).poke(1.B)
            c.io.mask(0).poke(0.B)
            c.io.dataIn(3).poke(2.U)
            c.io.dataIn(2).poke(3.U)
            c.io.dataIn(1).poke(2.U)
            c.io.dataIn(0).poke(1.U)
            c.clock.step(10)
        }
    }
}