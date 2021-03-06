package derevo.pureconfig

import derevo.{Derevo, Derivation, delegating}
import pureconfig.{ConfigReader, ConfigWriter}

@delegating("pureconfig.generic.semiauto.deriveReader")
object pureconfigReader extends Derivation[ConfigReader] {
  def instance[A]: ConfigReader[A] = macro Derevo.delegate[ConfigReader, A]
}

@delegating("pureconfig.generic.semiauto.deriveWriter")
object pureconfigWriter extends Derivation[ConfigWriter] {
  def instance[A]: ConfigWriter[A] = macro Derevo.delegate[ConfigWriter, A]
}

@delegating("pureconfig.module.magnolia.semiauto.reader.deriveReader")
object config extends Derivation[ConfigReader] {
  def instance[A]: ConfigReader[A] = macro Derevo.delegate[ConfigReader, A]
}

@delegating("pureconfig.module.magnolia.semiauto.writer.deriveWriter")
object configWriter extends Derivation[ConfigWriter] {
  def instance[A]: ConfigWriter[A] = macro Derevo.delegate[ConfigWriter, A]
}
